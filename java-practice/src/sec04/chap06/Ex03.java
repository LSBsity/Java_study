package sec04.chap06;

public class Ex03 {
    static void upTo5(int start) {
        System.out.println(start);
        if (start < 5) {
            upTo5(++start);
        } else {
            System.out.println("-- 종료 --");
        }
    }

    static int factorial(int num) {
        return num == 0 ? 1 : num * factorial(--num);
    }

    public static void main(String[] args) {
        upTo5(0);
        upTo5(2);
        upTo5(4);

        int fact1 = factorial(1);
        int fact2 = factorial(2);
        int fact3 = factorial(3);
        int fact4 = factorial(4);
        int fact5 = factorial(5);
    }
}
