package sec11.chap09;

import java.util.*;
import java.util.concurrent.*;

public class Ex02 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        //  💡 ConcurrentHashMap
        //  - 동기화된 해시맵
        //  - 맵을 구획으로 분할하여 각 구획에 대해 동기화를 적용
        //  - 각 쓰레드가 서로 다른 구획에 접근
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        Runnable toHashMap = () -> {
            for (int i = 0; i < 10000; i++) {
                hashMap.put("key" + i, i);
            }
        };
        Runnable toConcurrHashMap = () -> {
            for (int i = 0; i < 10000; i++) {
                concurrentHashMap.put("key" + i, i);
            }
        };

        measureTime("일반 해시맵", () -> {
            Thread t1 = new Thread(toHashMap);
            Thread t2 = new Thread(toHashMap);
            Thread t3 = new Thread(toHashMap);

            t1.start();
            t2.start();
            t3.start();
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
            }

            System.out.printf(
                    "일반 해시맵 사이즈 : %d%n",
                    hashMap.size()
            );
        });

        System.out.println("- - - - -");

        measureTime("Concurrent 해시맵", () -> {
            Thread t1 = new Thread(toConcurrHashMap);
            Thread t2 = new Thread(toConcurrHashMap);
            Thread t3 = new Thread(toConcurrHashMap);

            t1.start();
            t2.start();
            t3.start();
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
            }

            System.out.printf(
                    "Concurrent 해시맵 사이즈 = %d%n",
                    concurrentHashMap.size()
            );
        });
    }

    public static void measureTime(String taskName, Runnable runnable) {
        long startTime = System.nanoTime();

        runnable.run();

        long endTime = System.nanoTime();
        System.out.printf(
                "⌛️ %s 소요시간: %,d 나노초%n",
                taskName,
                endTime - startTime
        );
    }
}
