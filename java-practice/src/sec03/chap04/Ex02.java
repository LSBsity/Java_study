package sec03.chap04;

public class Ex02 {
    public static void main(String[] args) {
        boolean bool1 = true && true;
        boolean bool2 = true && false;
        boolean bool3 = false && true;
        boolean bool4 = false && false;

        boolean bool5 = true || true;
        boolean bool6 = true || false;
        boolean bool7 = false || true;
        boolean bool8 = false || false;

        int num = 4;

        boolean isPositiveAndOdd = num >= 0 && num % 2 == 1;
        boolean isPositiveOrOdd = num >= 0 || num % 2 == 1;

        boolean isPositiveAndEven = num >= 0 && num % 2 == 0;
        boolean isPositiveOrEven = num >= 0 || num % 2 == 0;

        num = 6;

        //  💡 &&가 ||보다 우선순위 높음
        boolean boolA = (num % 3 == 0) && (num % 2 == 0) || (num > 0) && (num > 10);
        boolean boolB = (num % 3 == 0) && ((num % 2 == 0) || (num > 0)) && (num > 10);
    }
}
