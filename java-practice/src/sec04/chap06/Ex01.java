package sec04.chap06;

public class Ex01 {
    static int add(int a, int b) {
        return a + b;
    }

    //  매개변수의 개수가 다름
    static int add(int a, int b, int c) {
        return a + b + c;
    }

    //  매개변수의 자료형이 다름
    static double add(double a, double b) {
        return a + b;
    }

    //  매개변수의 자료형 순서가 다름
    static String add(String a, char b) {
        return a + b;
    }

    static String add(char a, String b) {
        return a + b;
    }

    //  ⚠️ 반환 자료형이 다른 것은 오버로딩 안 됨 - 다른 함수명 사용
    //  static double add(int a, int b) { return (double) (a + b); }

    public static void main(String[] args) {
        int res1 = add(1, 2); // 🔴 스텝인투로 들어가 볼 것
        int res2 = add(3, 4, 5);
        double res3 = add(1.2, 3.4);
        String res4 = add("로보트 태권", 'V');
        String res5 = add('X', "Men");


    }
}
