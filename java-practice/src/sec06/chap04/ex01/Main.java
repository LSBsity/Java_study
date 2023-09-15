package sec06.chap04.ex01;

import sec05.chap08.ex01.*; //  💡 와일드카드로 임포트

public class Main {
    public static void main(String[] args) {


        YalcoGroup store1 = new YalcoChicken("울산");
        YalcoGroup store2 = new YalcoCafe("창원", true);

        YalcoGroup store3 = new YalcoGroup(1, "포항") {

            //  원본 메소드에 public 추가
            @Override
            public void takeOrder() {
                System.out.printf("유일한 얄코과메기 %s 과메기를 주문해주세요.%n", super.intro());
            }

            public void dryFish() {
                System.out.println("과메기 말리기");
            }
        };

        var store3Intro = store3.intro();
        store3.takeOrder();
        //store3.dryFish // ⚠️ 불가

        System.out.println("\n- - - - -\n");

        for (var store : new YalcoGroup[]{store1, store2, store3}) {
            store.takeOrder();
        }
    }
}
