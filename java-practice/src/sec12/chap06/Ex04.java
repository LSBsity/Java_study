package sec12.chap06;

import java.io.*;
import java.net.*;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        URL yalco = new URL("https://showcases.yalco.kr");
        URL people = new URL(yalco, "/java/people.csv");
        String PEOPLE_PATH = "java-practice/src/sec12/chap06/people.txt";

        HttpURLConnection conn = (HttpURLConnection) people.openConnection();

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code :" + responseCode);

        try (
                var is = conn.getInputStream();
                var isr = new InputStreamReader(is);
                var br = new BufferedReader(isr);
                var fw = new FileWriter(PEOPLE_PATH);
                var pw = new PrintWriter(fw)
        ) {
            String line;
            while((line = br.readLine()) != null) {
                try {
                    String[] pieces = line.split(",");
                    pw.println(
                            new Person(
                                    pieces[0],
                                    Integer.parseInt(pieces[1]),
                                    Double.parseDouble(pieces[2]),
                                    Boolean.parseBoolean(pieces[3])
                            )
                    );
                } catch (RuntimeException e) {
                    System.out.println("😵 처리 실패: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
