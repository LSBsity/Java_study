package sec11.chap01;

public class Thread1 extends Thread {
    @Override
    public void run() {

        for (var i = 0; i < 20; i++) {
            // 😴
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(1);
        }
    }
}