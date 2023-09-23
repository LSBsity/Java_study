package sec12.chap04;

import java.io.*;

public class Ex04 {
    public static void main(String[] args) {
        //  ⭐️ System의 out은 기본적으로 PrintStream 임 확인
        System.out.println(System.out.getClass());

        String PRINT_PATH = "java-practice/src/sec12/chap04/print.txt";

        PrintStream ps = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(PRINT_PATH);
            ps = new PrintStream(fos);

            //  💡 System의 out 변경
            //  - FileOutputStream 을 출력 대상으로 하는
            //  - 새 PrintStream으로
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("안녕히 계세요 여러분.");
        System.out.printf("%s로 뵙겠습니다.%n", "텍스트파일");
    }
}
