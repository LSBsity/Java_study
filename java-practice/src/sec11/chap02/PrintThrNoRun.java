package sec11.chap02;

public class PrintThrNoRun implements Runnable {
    int no;
    public PrintThrNoRun(int no) {
        this.no = no;
    }

    @Override
    public void run() {
        for (var i = 0; i < 20; i++) {
            System.out.print(no);
            // 시간지연
            for (var j = 0; j < Integer.MAX_VALUE; j++) {}
        }
    }
}