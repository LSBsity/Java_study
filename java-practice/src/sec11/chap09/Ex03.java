package sec11.chap09;

import java.util.concurrent.atomic.AtomicInteger;

public class Ex03 {
    static int count = 0;
    static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {


        Runnable incCount = () -> {
            for (int i = 0; i < 10000; i++) {
                count++;
                atomicCount.getAndIncrement();
            }
        };

        Thread t1 = new Thread(incCount);
        Thread t2 = new Thread(incCount);
        Thread t3 = new Thread(incCount);

        t1.start(); t2.start(); t3.start();

        try {
            t1.join(); t2.join(); t3.join();
        } catch (InterruptedException e) {}

        int result = count; // Thread의 중복으로 인해 결과값이 더 적게 나온다.
        int atomicResult = atomicCount.get(); // Thread가 하나씩만 접근하기에 중복이 없다.
    }
}
