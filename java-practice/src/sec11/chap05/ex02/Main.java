package sec11.chap05.ex02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Arrays.stream("철수,영희,돌준,병미,핫훈,짱은,밥태".split(","))
                .forEach(s -> new Thread(
                        new CustomerRun(s, coffeeMachine)
                ).start());

        new Thread(new ManagerRun(coffeeMachine)).start();
    }
}
