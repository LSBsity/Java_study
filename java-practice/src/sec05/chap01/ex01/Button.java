package sec05.chap01.ex01;

public class Button {

    char print;
    int space;
    String mode;

    Button(char print, int space, String mode) {
        this.print = print;
        this.space = space;
        this.mode = mode;
    }

    void place() {
        System.out.printf("표시: %c, 공간: %s, 모드: %s%n", print, space, mode);
    }
}