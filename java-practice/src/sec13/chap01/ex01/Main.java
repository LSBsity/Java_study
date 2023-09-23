package sec13.chap01.ex01;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //  💡 클래스를 가져오는 두 방법
        //  - 와일드카드<?> 사용 가능
        Class<Button> btnClass1 = Button.class;
        //  예외 던짐 : ClassNotFoundException
        Class<?> btnClass2 = Class.forName("sec13.chap01.ex01.Button");

        boolean areSame = btnClass1 == btnClass2;

        //  💡 모든 생성자 배열로 가져오기
        Constructor[] btn1Constrs = btnClass1.getConstructors();

        //  💡 생성자 가져오기
        //  - 주어진 인자 타입에 일치하는 것으로
        //  - 일치하는 것 없을 시 예외 던짐 : NoSuchMethodException
        Constructor<?> btn1Constr = btnClass1.getConstructor(String.class, int.class);

        //  💡 생성자 사용하기
        //  - 예외 던짐 : IllegalAccessException
        Button button1A = (Button) btn1Constr.newInstance("Enter", 3);
        //  각각에 맞는 인자들 넣어야 정상동작
        Button button1B = (Button)  btn1Constrs[0].newInstance();
        Button button1C = (Button)  btn1Constrs[1].newInstance("Tab", 2);

        //  💡 필드들 가져오기
        //  - 각 항목 펼쳐서 확인해 볼 것
        Field[] btnFields = btnClass1.getDeclaredFields();

        for (var f : btnFields) {
            System.out.printf(
                    "변수명: %s\n타입: %s\n선언된 클래스: %s\n\n",
                    f.getName(),
                    f.getType(),
                    f.getDeclaringClass()
            );
        }
        //  💡 특정 필드 이름으로 가져오기
        //  - 예외 던짐 : NoSuchFieldException
        //  - public 필드만 가능
        Field btn1Disabled = btnClass1.getField("disabled");
        //Field btnSpaces = btnClass1.getField("spaces"); //

        System.out.println("\n- - - - -\n");

        //  💡 메소드들 가져오기
        //  - 각 항목 펼쳐서 확인해 볼 것
        Method[] btnMethods = btnClass1.getDeclaredMethods();

        for (var m : btnMethods) {
            System.out.printf(
                    "메소드명: %s\n인자 타입(들): %s\n반환 타입: %s\n\n",
                    m.getName(),
                    Arrays.stream(m.getParameterTypes())
                            .map(Class::getSimpleName)
                            .collect(Collectors.joining(", ")),
                    m.getReturnType()
            );
        }

        System.out.println("\n- - - - -\n");

        //  ️⭐ Button 식별자를 코드에서 못 쓰는 상황 가정
        //  - 어떤 클래스가 들어올 지 모르는 상황 등...
        Object button2 = btnClass2
                .getConstructor(String.class, int.class)
                .newInstance("Space", 5);

        Field btn2Disabled = btnClass2.getField("disabled");
        //  💡 특정 인스턴스의 필드 값 얻기
        boolean btn2DisabledVal = (boolean) btn2Disabled.get(button2);

        //  💡 필드 값 변경
        btn2Disabled.set(button2, true);

        //  💡 필드 배열로 접근시
        for (var f : btnClass2.getDeclaredFields()) {

            f.setAccessible(true); // ⚠️ 이렇게 해주지 않으면 private일 시 예외 발생
            System.out.println(f.getName() + " : " + f.get(button2));
        }

        System.out.println("\n- - - - -\n");

        //  💡 메소드 호출
        Method btn2onclick = btnClass2
                .getMethod("onClick", boolean.class, int.class, int.class);
        btn2onclick.invoke(button2, false, 123, 455);

        System.out.println("\n- - - - -\n");

        //  💡 상위 클래스와 인터페이스들 가져오기
        Class<?> btn1Super = btnClass1.getSuperclass();
        Class[] btn1Interfaces = btnClass1.getInterfaces();
    }
}
