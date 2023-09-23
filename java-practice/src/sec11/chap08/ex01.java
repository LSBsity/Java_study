package sec11.chap08;

import java.util.*;
import java.util.stream.*;

public class ex01 {
    public static void main(String[] args) {
        Stream<Character> stream1 = Stream.of('A', 'B', 'C');

        //  💡 isParallel : 스트림이 병렬인지 여부
        var bool1 = stream1.isParallel();

        //  💡 parallel :  직렬 스트림을 병렬로 바꿈
        stream1.parallel();
        var bool2 = stream1.isParallel();

        //  💡 parallel : 병렬 스트림을 직렬로 바꿈
        stream1.sequential();
        var bool3 = stream1.isParallel();

        //  ⭐️ 처음부터 병렬 스트림으로 생성하기
        //  - Arrays와 Collection의 parallelStream 사용
        Stream<Integer> stream2 = Arrays.asList(1, 2, 3, 4, 5)
                .parallelStream();

        List<Double> dblList = new ArrayList<>(
                Arrays.asList(1.23, 2.34, 3.45)
        );
        Stream<Double> stream3 = dblList.parallelStream();
    }
}
