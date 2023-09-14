package sec05.chap04.ex01;

public class Main {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();

        String pb = phone.powerButton;
        String ss = phone.sdCardSlot;
        //String cu = phone.cpu; // ⚠️ private 변수엔 접근,변경 불가
    }
}
