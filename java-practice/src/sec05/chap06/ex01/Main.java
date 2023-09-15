package sec05.chap06.ex01;

public class Main {
    public static void main(String[] args) {
//        YalcoChickenDT dtStore1 = new YalcoChickenDT(108, "철원");
//
//        dtStore1.takeHallOrder();
//
//        dtStore1.takeDTOrder();
//        dtStore1.setDriveThruOpen(false);
//        dtStore1.takeDTOrder();

        System.out.println("\n- - - - -\n");

        YalcoChicken[] ycStores = {
                new YalcoChicken(3, "판교"),
                new YalcoChicken(17, "강남"),
                new YalcoChickenDT(108, "철원"),

        };

        for (YalcoChicken store : ycStores) {
            if (store instanceof YalcoChickenDT) {
                //  ⭐️ 자식 클래스의 기능을 사용하려면 명시적 타입 변환
                ((YalcoChickenDT) store).takeDTOrder();
            } else {
                store.takeHallOrder();
            }
        }
    }
}
