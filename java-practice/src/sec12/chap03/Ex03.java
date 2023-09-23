package sec12.chap03;

import java.io.*;

public class Ex03 {
    public static void main(String[] args) {
        String DATA_PATH = "java-practice/src/sec12/chap03/data.bin";

//        try (
//                FileOutputStream fos = new FileOutputStream(DATA_PATH);
//                DataOutputStream dos = new DataOutputStream(fos);
//        ) {
//
//            //  💡 각 자료형의 값을 이진 데이터로 저장
//            dos.writeBoolean(true);
//            dos.writeInt(123);
//            dos.writeDouble(3.14);
//            dos.writeChar('A');
//            dos.writeUTF("헬로헬로염"); // 💡 문자열을 UTF-8 형식으로
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//

        boolean read1;
        int read2;
        double read3;
        char read4;
        String read5;

        try (
                FileInputStream fis = new FileInputStream(DATA_PATH);
                DataInputStream dis = new DataInputStream(fis);
        ) {

            //  ⭐️ 쓴 순서와 같이 읽어야 함
            //  - 순서를 바꿔 볼 것
            //  - 오류가 나거나, 바뀐 곳들의 값이 잘못 읽힘
            //    - 문자열 이전 것들끼리 바꿔보기
            //    - 문자열을 다른 위치로 옮겨보기
            read1 = dis.readBoolean();
            read2 = dis.readInt();
            read3 = dis.readDouble();
            read4 = dis.readChar();
            read5 = dis.readUTF();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
