package sec05.chap02.ex02;

public class Main {
    public static void main(String[] args) {
        int[] ary1 = {3, 5, 9, 2, 8, 1, 4};
        int[] ary2 = {382, 194, 27, 915, 138};

        IntArrayInfo aryInf1 = new IntArrayInfo(ary1);
        IntArrayInfo aryInf2 = new IntArrayInfo(ary2);

        int ary1Max = aryInf1.max;
        double ary2Avg = aryInf2.average;
        int ary1n2Sum = aryInf1.sum + aryInf2.sum;
    }
}
