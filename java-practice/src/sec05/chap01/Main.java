package sec05.chap01;

public class Main {
    public static void main(String[] args) {
        //  1 버튼
        char btn1Print = '1';
        int btn1Space = 1;
        String btn1Mode = "DARK";
        placeButton(btn1Print, btn1Space, btn1Mode);

        //  더하기 버튼
        char btnPlusPrint = '+';
        int btnPlusSpace = 3;
        String btnPlusMode = "DARK";
        placeButton(btnPlusPrint, btnPlusSpace, btnPlusMode);

        //  클리어 버튼
        char btnClearPrint = 'C';
        int btnClearSpace = 2;
        String btnClearMode = "DARK";
        placeButton(btnClearPrint, btnClearSpace, btnClearMode);
    }

    static void placeButton(char print, int space, String mode) {
        System.out.printf("표시: %c, 공간: %s, 모드: %s%n", print, space, mode);
    }
}
