package sec11.chap06.ex02;

import java.util.*;
import java.util.stream.*;

public class TryCallable {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(i -> {
                    try {
                        intList.add(new RollDiceCall().call());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        System.out.println(String.join(
                ",",
                intList.stream().map(String::valueOf).toArray(value -> new String[value])
        ));
    }
}
