package sec05.chap04.ex02;

import sec05.chap04.ex01.SmartPhone;

public class Main {
    public static void main(String[] args) {
        Button button1 = new Button('1', 1);

        //Button.mode = "OCEAN"; // ⚠️ 불가
        Button.switchMode();

        //button1.space = 3; // ⚠️ 불가
        button1.setSpace(3);
        button1.setSpace(-1); // 걸러짐

        //char button1Print = button1.print; // ⚠️ 불가
        String button1Info = button1.getButtonInfo();
    }
}
