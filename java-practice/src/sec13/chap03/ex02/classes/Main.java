package sec13.chap03.ex02.classes;

import sec13.chap03.ex02.annotations.*;
import sec13.chap03.ex02.enums.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Object> objList = new ArrayList<>();

        Object[] objsToVerify = {

                new Introduction(
                        "홍길동", 28, "프로그래머",
                        "외길인생 자바 프로그래머입니다."),
                new Introduction(
                        "전우치토스", 20, "협객",
                        "나는 복수를 하지."),
                new Appointment(
                        "페르세우스", WeekDay.MON, 20,
                        "정신이 오락가락"),
                new Appointment(
                        "황금박쥐", WeekDay.WED, 14,
                        "두통"),
                new Appointment(
                        "정핫준", WeekDay.TUE, 12,
                        "콧물과 가래"),
                new Introduction(
                        "김갓난", 0, "영아",
                        "너무 young해서 영아")
        };

        List<Object> objsVerified = new ArrayList<>();

        for (var obj : objsToVerify) {
            try {
                objsVerified.add(
                        verifyObj(obj)
                );
                System.out.println("✅ 통과");
            } catch (Exception e) {
                System.out.println("🛑 반려 : " + e.getMessage());
                e.printStackTrace();
            } finally { // ⭐️
                System.out.println("- - - - -");
            }
        }
    }

    public static Object verifyObj(Object obj) throws Exception {
        Class<?> objClass = obj.getClass();
        ClassDesc cd = objClass.getAnnotation(ClassDesc.class);
        System.out.println(cd.value() + " 검증 시작");

        for (var f : objClass.getDeclaredFields()) {
            f.setAccessible(true);

            Object val = f.get(obj);

            //  🧪 필드의 어노테이션 검증 및 처리
            for (var a : f.getAnnotations()) {

                //  첫 글자 외 *으로
                if (a instanceof Blind) {
                    var s = (String) val;
                    f.set(obj, s.substring(0, 1) + "*".repeat(s.length() - 1));
                }

                //  최대 길이 검증
                if (a instanceof MaxLength) {
                    int maxLen = ((MaxLength) a).value();
                    if (((String) val).length() > maxLen) {
                        throw new Exception(
                                "%s 최대 길이(%d) 초과".formatted(f.getName(), maxLen)
                        );
                    }
                }

                //  최소값/최대값 검증
                //  💡 Repeatable 여럿을 썼을 경우 묶음으로 들어감
                if (a instanceof NumLimits) {
                    //  💡 value 메소드가 NumLimit[] 반환
                    for (var nl : ((NumLimits) a).value()) {
                        verifyNumLimit(f.getName(), nl, (int) val);
                    }
                }
                //  💡 Repeatable 이지만 하나만 들어간 경우
                if (a instanceof NumLimit) {
                    verifyNumLimit(f.getName(), (NumLimit) a, (int) val);
                }

                //  가용 요일 검증
                if (a instanceof WeekDaysAvail) {
                    var wda = (WeekDaysAvail) a;
                    var wd = (WeekDay) f.get(obj);
                    WeekDay[] availables = wda.value();
                    var available = false;
                    for (var inAvail : availables) {
                        if (wd == inAvail) available = true;
                    }
                    if (!available) throw new Exception(
                            "해당 요일(%s) 불가".formatted(wd.getName())
                    );
                }
            }
        }

        //  테스트해야 할 메소드 실행
        for (var m : objClass.getDeclaredMethods()) {
            for (var a : m.getAnnotations()) {
                if (a instanceof TestAndPrint) {
                    var tp = (TestAndPrint) a;
                    var printBefore = tp.before();
                    var printAfter = tp.after();

                    if (!printBefore.isBlank())
                        System.out.println(printBefore);
                    m.invoke(obj);
                    if (!printAfter.isBlank())
                        System.out.println(printAfter);
                }
            }

        }

        return obj;
    }

    public static void verifyNumLimit(
            String fieldName, NumLimit nl, int val
    ) throws Exception {
        if (nl.type() == LimitType.MIN && val < nl.to())
            throw new Exception(
                    "%s 범위(최소 %d) 오류".formatted(fieldName, nl.to())
            );
        if (nl.type() == LimitType.MAX && val > nl.to())
            throw new Exception(
                    "%s 범위(최대 %d) 오류".formatted(fieldName, nl.to())
            );
    }
}
