package sec11.chap04.ex02;

public class Cache3 {

    //  ⭐️ 해결책 2. 동기화 사용
    static boolean stop = false;

    //  💡 동기화된 클레스 메소드들 (getter & setter)
    synchronized public static boolean isStop() {
        return stop;
    }
    synchronized public static void setStop(boolean stop) {
        Cache3.stop = stop;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            while (!isStop()) {
                i++;
            }

            System.out.println("- - - 쓰레드 종료 - - -");
        }).start();

        try { Thread.sleep(1000);
        } catch (InterruptedException e) {}

        setStop(true);

        //  💡 동기화된 메소드로 변수에 접근 시
        //  - 캐시 재사용에 의한 문제가 발생하지 않음
    }
}