package sec11.chap08;

import java.util.stream.*;

public class ex02 {
    public static void main(String[] args) {
        final int RANGE = 10000000;

        measureTime("직렬 필터", () -> {
            var filtered = IntStream.range(0, RANGE)
                    .filter(i -> i % 2 == 0);
        });
        measureTime("병렬 필터", () -> {
            var filtered = IntStream.range(0, RANGE)
                    .parallel() // 💡 스트림을 병렬로 바꿔줌
                    .filter(i -> i % 2 == 0);
        });

        System.out.println("\n- - - - -\n");

        measureTime("직렬 매핑", () -> {
            var mapped = IntStream.range(0, RANGE).boxed()
                    .map(String::valueOf);
        });
        measureTime("병렬 매핑", () -> {
            var mapped = IntStream.range(0, RANGE).boxed()
                    .parallel()
                    .map(String::valueOf);
        });

        System.out.println("\n- - - - -\n");

        //  ⭐️ reduce : 병렬시 오히려 느려짐
        measureTime("직렬 접기", () -> {
            var reduced = IntStream.range(0, RANGE)
                    .reduce(Integer::sum);
        });
        measureTime("병렬 접기", () -> {
            var reduced = IntStream.range(0, RANGE)
                    .parallel()
                    .reduce(Integer::sum);
        });

        System.out.println("\n- - - - -\n");

        //  ⭐️ sum : 개수가 커질수록 병렬시 유리해짐
        //  - 숫자 조정해 볼 것
        measureTime("직렬 합계", () -> {
            var sum = IntStream.range(0, RANGE)
                    .sum();
        });
        measureTime("병렬 합계", () -> {
            var sum = IntStream.range(0, RANGE)
                    .parallel()
                    .sum();
        });

        System.out.println("\n- - - - -\n");

        final int TRI_RANGE = 10;
        //final int TRI_RANGE = RANGE; // 혼합이 더 느려짐

        measureTime("직렬 3종", () -> {
            var tri = IntStream.range(0, TRI_RANGE)
                    .filter(i -> i % 2 == 0)
                    .map(i -> i + 1)
                    .reduce(Integer::sum);
        });
        measureTime("병렬 3종", () -> {
            var tri = IntStream.range(0, TRI_RANGE)
                    .parallel()
                    .filter(i -> i % 2 == 0)
                    .map(i -> i + 1)
                    .reduce(Integer::sum);
        });

        //  ⭐️ 작업에 따라 병렬과 직렬의 혼합이 유리할 수 있음
        //  - 이 작업의 경우 : 데이터 개수가 적음
        //  - 성능이 중요할 시 테스트해가며 최적의 코드를 찾을 것
        measureTime("혼합 3종", () -> {
            var tri = IntStream.range(0, TRI_RANGE)
                    .parallel()
                    .filter(i -> i % 2 == 0)
                    .map(i -> i + 1)
                    .sequential() // ⭐️
                    .reduce(Integer::sum);
        });
    }

    public static void measureTime(String taskName, Runnable runnable) {
        //  💡 System.nanoTime : 시간차를 구하는 데 사용됨
        //  - 정수 반환, ⭐️ 단 실제 현재 시간과는 상관없음
        //    - 초시계를 보고 현재 시각을 알 수 없듯이
        //  - 두 시점의 값을 비교하여 속도를 측정하는 용도로 사용
        long startTime = System.nanoTime();

        runnable.run();

        long endTime = System.nanoTime();
        System.out.printf(
                "⌛️ %s 소요시간: %12d 나노초%n",
                taskName,
                endTime - startTime
        );
    }
}
