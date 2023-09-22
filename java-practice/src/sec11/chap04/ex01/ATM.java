package sec11.chap04.ex01;

import java.util.Random;

public class ATM {
    private int balance = 0;

    public void addMoney(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    //  💡 앞에 synchronized를 붙이고 다시 실행해 볼 것
    public void withdraw(String name, int amount) {

        //  💡 또는 아래 내용을 이 블록으로 옮겨 볼 것
        //  - this는 현 쓰레드를 의미함
        //  - 메소드 내의 특정 작업만 동기화가 필요할 때
        synchronized (this) {
            if (balance < amount) return;

            System.out.printf(
                    "💰 %s 인출 요청 (현 잔액 %d)%n",
                    name, balance
            );
            try {
                Thread.sleep(new Random().nextInt(700, 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= amount;
            System.out.printf(
                    "✅ %s 인출 완료 (현 잔액 %d)%n",
                    name, balance
            );
        }


    }
}