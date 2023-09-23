package sec12.chap07;

import java.io.*;
import java.net.*;


public class TCPServer {

    //  💡 내 컴퓨터를 의미하는 IP주소
    //  - 일반적으로 localhost로 매핑
    public static final String SERVER_IP = "127.0.0.1";

    //  IP가 아파트 주소라면 포트는 게이트 번호
    public static final int PORT_NO = 1234;

    public static void main(String[] args) {

        try (
                //  💡 ServerSocket
                //  - 클라이언트(들)로부터 요청을 받기 위한 소켓
                //  - 연결을 받아 Socket 인스턴스 반환
                ServerSocket serverSkt = new ServerSocket(PORT_NO)
        ) {
            while (true) {
                try (
                        //  💡 Socket : 클라이언트로부터 요청이 오면 반환되는 소켓
                        Socket clientSkt = serverSkt.accept();

                        //  💡 클라이언트로부터 받을 스트림
                        var is = clientSkt.getInputStream();
                        var isr = new InputStreamReader(is);
                        var br = new BufferedReader(isr);
                        var sw = new StringWriter();
                        var piw = new PrintWriter(sw);

                        //  💡 클라이언트에게 보낼 스트림
                        var os = clientSkt.getOutputStream();
                        //  💡 두 번째 인자 : autoflush
                        //  - 값이 프린트 될 때마다 바로 스트림으로 출력할지 여부
                        var pow = new PrintWriter(os, true);
                ) {
                    String line;
                    int lineCount = 1;
                    while ((line = br.readLine()) != null) {
                        piw.printf(
                                "%3d :  %s%n".formatted(
                                        lineCount++, line
                                )
                        );
                        //  💡 클라이언트에게 되돌려보낼 메시지
                        pow.printf("✅ 수신: %s... 등 %d자%n".formatted(
                                line.substring(
                                        0, Math.min(3, line.length())

                                ), line.length()
                        ));
                    }
                    System.out.println(sw);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}