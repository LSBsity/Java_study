package sec07.chap01.ex02;

public class Main {
    public static void main(String[] args) {
        Click click1 = new Click(123, 456, 5323487);
        Click click2 = new Click(123, 456, 5323487);
        Click click3 = new Click(123, 456, 2693702);
        Click click4 = new Click(234, 567, 93827345);

        boolean bool1 = click1 == click1;
        boolean bool2 = click1 == click2;
        boolean bool3 = click1 == click3;
        boolean bool4 = click1 == click4;

        boolean boolA = click1.equals(click1);
        boolean boolB = click1.equals(click2);
        boolean boolC = click1.equals(click3);
        boolean boolD = click1.equals(click4);
    }
}
