package sec13.chap04.ex01;

public class Main {
    public static void main(String[] args) {
        try {
            Thread.sleep(2000);

            //  ⭐️ 아래의 클래스를 로드 & 초기화하는 시점
            NoUse noUse1 = new NoUse();
            NoUse noUse2 = new NoUse();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
