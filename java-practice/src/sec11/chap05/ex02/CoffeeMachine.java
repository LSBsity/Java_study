package sec11.chap05.ex02;

import sec11.chap04.ex01.*;

public class CoffeeMachine {
    final int CUP_MAX = 10;
    int cups = CUP_MAX;

    synchronized public void takeout(CustomerRun customer) {
        if (cups < 1) {
            System.out.printf("[%d] 😭 %s 커피 없음%n", cups, customer.name);
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.printf("[%d] ☕️ %s 테이크아웃%n", cups, customer.name);
            cups--;
        }

        notifyAll();
        try {
            wait(); // 커피를 타고 나감
        } catch (InterruptedException e) {
        }
    }

    synchronized public void fill() {
        if (cups > 3) {
            System.out.printf("[%d] 👌 재고 여유 있음...%n", cups);
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.printf("[%d] ✅ 커피 채워넣음%n", cups);
            cups = CUP_MAX;
        }

        notifyAll();
        try {
            wait(); // 커피를 채우고 나감
        } catch (InterruptedException e) {
        }
    }
}
