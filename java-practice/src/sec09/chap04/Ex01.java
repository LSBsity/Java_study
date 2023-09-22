package sec09.chap04;

import java.util.*;
import java.util.stream.*;

public class Ex01 {
    public static void main(String[] args) {
        List<Integer> int0To9 = new ArrayList<>(
                Arrays.asList(5, 2, 0, 8, 4, 1, 7, 9, 3, 6)
        );
        //  홀수만 골라낸 다음 정렬하여 "1, 3, 5..."와 같은 문자열로 만들어보기
        //  기존의 방식
        List<Integer> odds = new ArrayList<>();
        for (var i : int0To9) {
            if (i % 2 == 1) odds.add(i);
        }
        odds.sort(Integer::compare);

        List<String> oddsStrs = new ArrayList<>();
        for (var i : odds) {
            oddsStrs.add(String.valueOf(i));
        }
        var oddsStr = String.join(", ", oddsStrs);

        //  ⭐ 스트림을 사용한 방식
        //  각 라인이 무엇을 반환하는지 확인할 것
        var oddsStrStreamed = int0To9
                .stream()
                .filter(i -> i % 2 == 1)
                .sorted(Integer::compare)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
