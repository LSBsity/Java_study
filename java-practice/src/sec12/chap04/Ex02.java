package sec12.chap04;

import java.io.*;
import java.nio.charset.*;

public class Ex02 {
    public static void main(String[] args) {
        var TYPE_PATH = "java-practice/src/sec12/chap04/my_typing.txt";
        var charset = StandardCharsets.UTF_8;
        System.out.println("⌨️ 한 줄씩 입력하고 quit을 입력해 종료하세요.");
        try (
                //  💡 사용자의 타이핑으로부터 입력 받기
                //  - try-with-resources :
                //  - while을 통한 반복작업이 종료되면 close로 모두 닫힘
                InputStreamReader ir = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(ir);

                //  입력받은 내용 줄별로 파일에 쓰기
                FileOutputStream fos = new FileOutputStream(TYPE_PATH);
                OutputStreamWriter ow = new OutputStreamWriter(fos, charset);
                BufferedWriter bw = new BufferedWriter(ow);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase("quit")) break;

                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
