package sec11.chap09;

import java.util.concurrent.atomic.*;

public class Ex04 {
    static Counter counter = new Counter(0);

    //  💡 AtomicReference : 참조 타입을 원자적으로 다루기 위한 클래스
    //  - ⚠️ 이 클래스의 인스턴스 자체는 atomic이 #아님
    static AtomicReference atomicCounter = new AtomicReference(new Counter(0));

    public static void main(String[] args) {

        Runnable nonAtomic = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increase();
            }
        };
        Runnable atomic = () -> {
            for (int i = 0; i < 10000; i++) {

                Counter before, after;
                do {
                    before = (Counter) atomicCounter.get();
                    after = new Counter(before.getCount() + 1);

                    // 💡 compareAndSet : ⭐️ atomic 메소드
                    //  - 기존 값과 비교하여 같으면 새로운 값으로 교체

                    //  ⭐️ do-while을 사용하여, 다른 쓰레드가 중간에 개입한 경우를 제외
                    //  - atomicCounter의 값이 before와 같다면
                    //  - after로 교체한 뒤 true 반환
                } while (!atomicCounter.compareAndSet(before, after));
            }
        };

        Thread t1 = new Thread(nonAtomic);
        Thread t2 = new Thread(nonAtomic);
        Thread t3 = new Thread(nonAtomic);

        Thread t4 = new Thread(atomic);
        Thread t5 = new Thread(atomic);
        Thread t6 = new Thread(atomic);

        t1.start(); t2.start(); t3.start();
        t4.start(); t5.start(); t6.start();

        try {
            t1.join(); t2.join(); t3.join();
            t4.join(); t5.join(); t6.join();
        } catch (InterruptedException e) {}

        int result = counter.getCount();
        int atomicResult = ((Counter) atomicCounter.get()).getCount();
    }
}
