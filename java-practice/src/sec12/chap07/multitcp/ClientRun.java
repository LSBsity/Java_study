package sec12.chap07.multitcp;

import java.io.*;
import java.net.*;
import java.util.*;

import static sec12.chap07.multitcp.ServerMain.HOST;
import static sec12.chap07.multitcp.ServerMain.PORT_NUM;

public class ClientRun implements Runnable {
    private static int lastId = 0;
    private final int ID = ++lastId;
    private Random random = new Random();

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(0, 10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (
                var skt = new Socket(HOST, PORT_NUM);

                var os = skt.getOutputStream();
                var pw = new PrintWriter(os, true);

                var is = skt.getInputStream();
                var isr = new InputStreamReader(is);
                var br = new BufferedReader(isr);
        ) {
            var toSend = ID + "번 요청";
            pw.println(toSend);
            System.out.println("📣 전송 : " + toSend);

            // ⭐️ 이 부분에서 서버로부터의 딜레이 발생

            System.out.println("✅ 응답 : " + br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}