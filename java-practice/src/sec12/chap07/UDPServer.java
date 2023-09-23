package sec12.chap07;

import java.io.*;
import java.net.*;

public class UDPServer {

    public static final int PORT_NO = 2345;
    public static void main(String[] args) {

        //  💡 DatagramSocket : Closable
        //  - UDP 통신에 사용되는 소켓
        //  - 서버측에서 생성할 때 포트번호 부여
        try (DatagramSocket serverSkt = new DatagramSocket(PORT_NO)) {

            while (true) {
                byte[] receiveData = new byte[1024];

                //  💡 DatagramPacket : 주고받는 소포
                //  - 아래에서는 받아온 소포
                DatagramPacket receivePacket = new DatagramPacket(
                        receiveData, receiveData.length
                );
                serverSkt.receive(receivePacket);

                String received = new String(
                        receivePacket.getData(),
                        0, receivePacket.getLength()
                );
                System.out.println("🖥️ 수신 : " + received);

                for (var i = 0; i < 9; i++) {
                    var answer = received + " - 효과 " + (i + 1);
                    byte[] toSend = answer.getBytes();

                    //  💡 보내는 소포
                    DatagramPacket sendPacket = new DatagramPacket(
                            toSend,                         // 내용물
                            toSend.length,                  // 소포 크기
                            receivePacket.getAddress(),     // 주소 (InetAddress)
                            receivePacket.getPort()         // 현관 번호
                    );

                    //  💡 TCP처럼 스트림 열고 순서대로 흘려보내는 게 아니라
                    //  - 쿨하게 택배 부쳐서 보내버림
                    //  - 택배 직원들이 줄 서서 가는 게 아님
                    //  - 늦게 보낸 것이 먼저 도착할 수도
                    serverSkt.send(sendPacket);
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
        }
    }
}
