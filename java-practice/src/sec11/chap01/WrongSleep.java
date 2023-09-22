package sec11.chap01;

import java.util.stream.*;

public class WrongSleep {
    public static void main(String[] args) {
        Thread sleeper = new Thread(
                () -> IntStream.range(0, 5)
                        .forEach(i -> {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println('쿨');
                        })
        );
        sleeper.start();

        try {
            //  ⚠️ sleeper 쓰레드를 재우려고 했지만
            //  - sleep은 정적 메소드!
            //  - 현 쓰레드가 자버림
            sleeper.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("잘잤다!");
    }
}
