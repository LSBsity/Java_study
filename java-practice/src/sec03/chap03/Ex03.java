package sec03.chap03;

public class Ex03 {
    public static void main(String[] args) {
        //  같은 문자열인지 여부 반환
        boolean bool1 = 'A' == 'A';
        boolean bool2 = 'A' == '가';

        //  숫자와 비교할 시 해당 정수값 기준으로
        boolean bool3 = 'A' == 65;
        boolean bool4 = 'A' > 64.0;
        boolean bool5 = 'A' > 66f;

        //  사전순 상 먼저 오는 쪽이 작음
        boolean bool6 = 'A' < 'B';
        boolean bool7 = '가' > '나';
    }
}
