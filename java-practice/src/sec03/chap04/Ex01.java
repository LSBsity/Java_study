package sec03.chap04;

public class Ex01 {
    public static void main(String[] args) {
        boolean bool1 = true;
        boolean bool2 = false;

        boolean bool3 = !true;
        boolean bool4 = !false;

        boolean bool5 = !!bool3;
        boolean bool6 = !!!bool3;

        boolean bool7 = !(1 > 2);
        boolean bool8 = !((5 / 2) == 2.5);
        boolean bool9 = !((3f + 4.0 == 7) != ('A' < 'B'));
    }
}
