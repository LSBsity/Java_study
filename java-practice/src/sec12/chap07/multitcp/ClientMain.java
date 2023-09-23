package sec12.chap07.multitcp;

import java.util.concurrent.*;

public class ClientMain {
    public static void main(String[] args) {
        //  💡 클라이언트는 10개의 쓰레드 풀, 20개의 요청
        ExecutorService es = Executors.newFixedThreadPool(10);

        for (var i = 0; i < 20; i++) {
            es.execute(new ClientRun());
        }
        es.shutdown(); // 👌 요청을 보내면 끝이므로 닫아줌
    }
}
