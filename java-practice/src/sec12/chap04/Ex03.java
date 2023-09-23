package sec12.chap04;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class Ex03 {
    public static void main(String[] args) {
        String input = "반~갑구만,\n반~가워요!\n반~갑구만,\n반~갑습니다~!";
        String output;

        //  💡 StringReader & StringWriter
        //  - 문자열 데이터를 '메모리에서' 읽거나 쓸 때 사용
        //    - 즉 파일 입출력 등이 아닌, 메모리상에서 문자열을 다룰 때
        //  - 대용량 문자열에 대한 텍스트 처리에 적합
        try (
                StringReader sr = new StringReader(input);
                StringWriter sw = new StringWriter();
        ) {
            int c;
            while ((c = sr.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();

            sw.write("어쩔티비");
            sw.write(" ");
            sw.write("저쩔티비");

            output = sw.toString(); // 💡 문자열 최종 반환
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(output);

        System.out.println("\n- - - - -\n");

        String csvTxt = ""
                + "1, 2, 3, 4, 5\n"
                + "6, 7, 8, 9, 10\n"
                + "11, 12, 13, 14, 15\n"
                + "16, 17, 18, 19, 20\n"
                + "21, 22, 23, 24, 25"
                ;
        List<Integer[]> fromCsv = new ArrayList<>();

        try (
                StringReader sr = new StringReader(csvTxt);
                BufferedReader br = new BufferedReader(sr);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                fromCsv.add(
                        Arrays.stream(
                                        line.replace(" ", "").split(",")
                                ).map(Integer::parseInt)
                                .toArray(Integer[]::new)
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Charset charset = StandardCharsets.UTF_8;
        String CSV_PATH = "java-practice/src/sec12/chap04/numbers.csv";

        //  ⭐️ StringWriter는 내부적으로 StringBuilder 사용
        //  - write 메소드가 append 호출
        try (
                StringWriter sw = new StringWriter();
                //  💡 PrintWriter : 문자열의 출력을 간편하게 도와줌
                PrintWriter pw = new PrintWriter(sw);

                FileWriter fw = new FileWriter(CSV_PATH, charset);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            fromCsv.stream()
                    .map(intArr -> Arrays.stream(intArr)
                            .map(i -> i * i)
                            .toArray(Integer[]::new)
                    ).forEach(array -> {
                        //  💡 PrintWriter를 사용해서 프린트하듯 작성
                        //  - StringWriter로 출력되어 전송됨
                        pw.printf(
                                "%d, %d, %d, %d, %d",
                                array
                        );
                        pw.println();
                    });
            String result = sw.toString();
            System.out.println(result);
            bw.write(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
