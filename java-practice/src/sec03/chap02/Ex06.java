package sec03.chap02;

public class Ex06 {
    public static void main(String[] args) {
        int int1 = 5;
        float flt1 = 5f;
        double dbl1 = 5.0;
        double dbl2 = 7.89;

        //  💡 정수/실수간, 다른 숫자 자료형간 사용 가능
        boolean bool0 = 123 == 123F;

        boolean bool1 = int1 == flt1;
        boolean bool2 = flt1 == dbl1;
        boolean bool3 = int1 == dbl2;

        boolean bool4 = int1 > dbl2;
        boolean bool5 = flt1 >= dbl2;
        boolean bool6 = dbl1 < dbl2;
    }
}
