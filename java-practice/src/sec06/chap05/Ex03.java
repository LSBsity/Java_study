package sec06.chap05;

public class Ex03 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("메뉴와 맵기를 모두 입력해주세요.");
            return;
        }

        String menuName = args[0];
        String spicyLevel = args[1];

        if (spicyLevel.length() != 1) {
            System.out.println("맵기를 한 자리 숫자로 입력해주세요.");
            return;
        }
        if (!"0123456789".contains(spicyLevel)) {
            System.out.println("맵기는 숫자로 입력해주세요.");
            return;
        }

        System.out.printf("%s 맵기 강도 %s로 주문%n", menuName, spicyLevel);
    }
}
