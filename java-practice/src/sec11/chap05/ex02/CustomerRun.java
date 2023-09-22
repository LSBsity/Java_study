package sec11.chap05.ex02;

public class CustomerRun implements Runnable {
    String name;
    CoffeeMachine coffeeMachine;

    public CustomerRun(String name, CoffeeMachine coffeeMachine) {
        this.name = name;
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void run() {
        while (true) {
            coffeeMachine.takeout(this);
        }
    }
}