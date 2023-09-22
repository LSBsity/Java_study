package sec11.chap04.ex02;

public class Cache2 {

    //  ⭐️ 해결책 1. volatile 사용
    volatile static boolean stop = false;
    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }

            System.out.println("- - - 쓰레드 종료 - - -");
        }).start();

        try { Thread.sleep(1000);
        } catch (InterruptedException e) {}

        stop = true;

        //  💡 volatile 연산자
        //  - 변수의 값이 변경될 때마다 메모리에 업데이트
        //  - 멀티쓰레딩 환경에서 캐싱에 의한 문제 방지
        //  - 동기화와는 다름! 값 변경만 바로 확인시켜줌
    }
}