package sec12.chap06;

import java.io.*;
import java.net.*;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        URL yalco = new URL("https://showcases.yalco.kr");
        URL home = new URL(yalco, "/java/index.html");

        //  ⭐️ 예외를 던짐
        //  Closable이 아님 : try-with-resource로는 사용되지 못함
        URLConnection conn = null;
        try {
            conn = home.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (
                InputStream is = conn.getInputStream();

                var isr = new InputStreamReader(is);
                var br = new BufferedReader(isr);

                var sw = new StringWriter();
                var pr = new PrintWriter(sw)
        ) {
            String line;
            int lineCount = 1;
            while ((line = br.readLine()) != null) {
                pr.printf("%3d :  %s%n", lineCount++, line);
            }

            // ⭐️ StringWriter는 출력시 toString 생략 가능
            System.out.println(sw);
        }
    }
}
