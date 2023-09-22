package sec10.chap06;

import sec07.chap04.*;

import java.util.*;
import java.util.stream.*;

public class Ex02 {
    public static void main(String[] args) {
        //  💡 Optional 만들기
        //  of : 담으려는 것이 확실히 있을 때
        Optional<String> catOpt = Optional.of("Cat");
        //  ⚠️ of로 null을 담으면 NPE
        //catOpt = Optional.of(null);

        //  ofNullable : 담으려는 것이 null일 수도 있을 때
        Optional<String> dogOpt = Optional.ofNullable("Dog");
        Optional<String> cowOpt = Optional.ofNullable(null);

        //  명시적으로 null을 담으려면 empty 메소드 사용
        Optional<String> henOpt = Optional.empty();

        catOpt = getCatOpt();

        List<Optional<Unit>> randomUnitOpts = new ArrayList<>();
        IntStream.range(0, 20).forEach(i -> randomUnitOpts.add(randomUnitOpt()));

        //  ⭐️ Optional의 값 사용하기
        randomUnitOpts.stream().forEach(opt -> System.out.println(opt.isPresent() // 있다면 true
                //opt.isEmpty() // 없다면 true

                //opt.get() // 있다면 반환, 없다면 NPE

                // 💡 없을 시 다른 것 반환 (기본값으로 사용)
                //opt.orElse(new Swordman(Side.RED))
        ));

        System.out.println("\n- - - - -\n");

        randomUnitOpts.stream().forEach(opt -> {
            //  있다면 때 실행할 Consumer
            //opt.ifPresent(System.out::println);
            //  있다면 실행할 Consumer, 없다면 실행할 Runner(없으므로)
            opt.ifPresentOrElse(unit -> System.out.println(unit), () -> System.out.println("(유닛 없음)"));
        });

        System.out.println("\n- - - - -\n");

        List<Optional<Integer>> optInts = new ArrayList<>();
        IntStream.range(0, 20).forEach(i -> {
            optInts.add(Optional.ofNullable(new Random().nextBoolean() ? i : null));
        });

        //  💡 Optional의 filter와 map 메소드
        optInts.stream().forEach(opt -> {
            System.out.println(opt
                    //  ⭐️ 걸러진 것은 null로 인식됨
                    //  - 스트림의 filter처럼 건너뛰는 것이 아님!
                    .filter(i -> i % 2 == 1).map(i -> "%d 출력".formatted(i)).orElse("(SKIP)"));
        });
    }

    public static Optional<String> getCatOpt() {
        return Optional.ofNullable(new Random().nextBoolean() ? "Cat" : null);
    }

    public static Optional<Unit> randomUnitOpt() {
        switch (new Random().nextInt(0, 3)) {

            //  💡 각 return 문을 가지므로 break 필요 없음
            case 0:
                return Optional.of(new Knight(Side.BLUE));
            case 1:
                return Optional.of(new MagicKnight(Side.BLUE));

            default:
                return Optional.empty();
        }
        //  ⭐️ Optional을 반환하는 메서드는 null을 반환하도록 하지 말 것!
        //  - 대신 빈 Optional을 반환 (Optional.empty)
        //  - NPE를 방지하기 위한 메소드이므로
    }
}
