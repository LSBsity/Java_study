package sec11.chap05.ex01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PhoneBooth phoneBooth = new PhoneBooth();

        Arrays.stream("김병장,이상병,박일병,최이병".split(","))
                .forEach(s -> new Thread(
                        new SoldierRun(s, phoneBooth)
                ).start());
    }
}
