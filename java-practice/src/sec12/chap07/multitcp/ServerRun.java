package sec12.chap07.multitcp;

import java.io.*;
import java.net.*;

public class ServerRun implements Runnable {
    private Socket clientSkt;

    public ServerRun(Socket clientSkt) {
        this.clientSkt = clientSkt;
    }

    @Override
    public void run() {
        try (
                var is = clientSkt.getInputStream();
                var isr = new InputStreamReader(is);
                var br = new BufferedReader(isr);

                var os = clientSkt.getOutputStream();
                var pw = new PrintWriter(os, true);
        ) {

            //  ⏳ 3초 대기
            Thread.sleep(3000);

            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line + " 확인");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}