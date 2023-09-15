package sec06.chap03.ex02;

public class Main {
    public static void main(String[] args) {
        YalcoChicken.LaunchTF launchTF1 = new YalcoChicken.LaunchTF("마산", "김영희");
        YalcoChicken.LaunchTF launchTF2 = new YalcoChicken.LaunchTF("영월", "이철수");

        YalcoChicken store1 = launchTF1.launch();
        YalcoChicken store2 = launchTF2.launch();

        YalcoChicken.Gift[] gifts = {
                store1.getGift("홍길동"),
                store1.getGift("전우치"),
                store2.getGift("옥동자")
        };

    }
}
