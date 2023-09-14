package sec04.chap03;

public class Ex02 {
    public static void main(String[] args) {
        //  종료조건이 없는 for 루프
//        for (;;) {
//            System.out.println("영원히");
//        }
        //System.out.println("닿지 않아"); // ⚠️ 실행되지 않음

        //  종료조건을 만족시키지 못하는 무한루프
        for (int i = 0; i < 10; i++) {
            System.out.println("그래도");
            i--;
        }
        System.out.println("닿지 않아"); // ⚠️ 실행되지 않음


    }
}
