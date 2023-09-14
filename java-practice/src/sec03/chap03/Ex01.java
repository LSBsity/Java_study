package sec03.chap03;

public class Ex01 {
    public static void main(String[] args) {
        //  각 문자는 상응하는 정수를 가짐
        char ch1 = 'A';
        char ch2 = 'B';
        char ch3 = 'a';
        char ch4 = 'a' + 1;
        char ch5 = '가';
        char ch6 = '가' + 1;
        char ch7 = '가' + 2;
        char ch8 = '가' + 3;
        char ch9 = '나';

        int ch1Int = (int) ch1;
        int ch9Int = (int) ch9;

        // 문자 리터럴과 숫자, 유니코드로 표현 가능
        char ch10 = 'A';
        char ch11 = 65;
        char ch12 = '\u0041';
    }
}
