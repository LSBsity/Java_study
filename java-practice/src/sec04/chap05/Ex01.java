package sec04.chap05;

public class Ex01 {
    //  ⭐️ 메인 메소드 외부에 선언할 것
    static void addSubtMultDiv(double a, double b) {
        System.out.printf("%f + %f = %f%n", a, b, a + b);
        System.out.printf("%f - %f = %f%n", a, b, a - b);
        System.out.printf("%f * %f = %f%n", a, b, a * b);
        System.out.printf("%f / %f = %f%n", a, b, a / b);
    }

    public static void main(String[] args) {
        double x = 3, y = 4;

        System.out.printf("%f + %f = %f%n", x, y, x + y);
        System.out.printf("%f - %f = %f%n", x, y, x - y);
        System.out.printf("%f * %f = %f%n", x, y, x * y);
        System.out.printf("%f / %f = %f%n\n\n", x, y, x / y);

        double xx = 3, yy = 4;
        addSubtMultDiv(xx, yy);
    }
}
