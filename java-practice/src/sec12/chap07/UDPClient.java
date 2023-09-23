package sec12.chap07;

import java.io.*;
import java.net.*;
import static sec12.chap07.UDPServer.PORT_NO;

public class UDPClient {

    public static final String SERVER_IP = "127.0.0.1";
    public static void main(String[] args) {

        try (DatagramSocket clientSkt = new DatagramSocket()) {

            //  💡 InetAddress : IP주소를 표현하고 다루는 데 사용
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);

            //  ⭐ UDP는 작은 데이터를 자주 주고받는데 더 적합
            //  - 안전성보다는 속도
            //  - 온라인 게임 등...
            for (var i = 0; i < 100; i++) {
                byte[] sendData = ("click " + (i + 1)).getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData,
                        sendData.length,
                        serverAddr,
                        PORT_NO // ⭐️ UDP 것으로 임포트할 것!
                );

                clientSkt.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(
                        receiveData, receiveData.length
                );

                for (var j = 0; j < 9; j++) {
                    clientSkt.receive(receivePacket);

                    String response = new String(
                            receivePacket.getData(),
                            0, receivePacket.getLength()
                    );
                    System.out.println("🖱️ 수신 : " + response);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //  ⭐ 실제 네트워킹에서는 양쪽 모두 순서 보장되지 않음
        //  - 로컬 실습에서는 네트워크 지연이 없으므로...
    }
}