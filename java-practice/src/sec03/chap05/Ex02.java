package sec03.chap05;

public class Ex02 {
    public static void main(String[] args) {
        String hl1 = "Hello";
        String hl2 = "Hello";
        String wld = "World";

        //  리터럴끼리는 == 을 사용하여 비교 가능
        boolean bool1 = hl1 == hl2;
        boolean bool2 = hl1 == wld;

        String hl3 = new String("Hello");
        String hl4 = new String("Hello");
        String hl5 = hl4;

        //  💡 인스턴스와 비교하려면 .equals 메소드를 사용해야 함
        //   특별한 경우가 아니면 문자열은 .equals로 비교할 것
        boolean bool3 = hl3 == hl4;

        boolean bool4 = hl1.equals(hl2);
        boolean bool5 = hl1.equals(hl3);
        boolean bool6 = hl3.equals(hl4);
        boolean bool7 = wld.equals(hl2);

        //  같은 곳을 참조하는 인스턴스들
        boolean bool8 = hl4 == hl5;

        //  ⭐️ 각각의 메모리상 주소 식별자 비교
        int hl1hash = System.identityHashCode(hl1);
        int hl2hash = System.identityHashCode(hl2);
        int hl3hash = System.identityHashCode(hl3);
        int hl4hash = System.identityHashCode(hl4);
        int hl5hash = System.identityHashCode(hl5);
    }
}
