package sec11.chap09;

import java.util.*;

public class Ex01 {
    public static void main(String[] args) {
        //  3개의 쓰레드에서 한 해시맵에 10000개의 데이터를 주입

        Map<String, Integer> hashMap = new HashMap<>();

        Runnable toHashMap = () -> {
            for (int i = 0; i < 10000; i++) {
                hashMap.put("key" + i, i);
            }
        };

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
    }
}
