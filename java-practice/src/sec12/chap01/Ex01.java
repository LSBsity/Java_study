package sec12.chap01;

import java.io.*;

public class Ex01 {
    public static final String CUR_PATH = "java-practice/src/sec12/chap01/";

    public static void main(String[] args) {
        var filePath = "file1.txt";
        filePath = CUR_PATH + filePath; //  ⭐️ 상대경로

        //  💡 파일명만 적으면 프로젝트 파일 바로 안에 저장
        //  - 상대경로 또는 절대경로를 앞에 추가하여 지정

        File file1 = new File(filePath);
        System.out.println(file1.exists()); // 생성 후 다시 실행해 볼 것

        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                System.out.println("🛑 파일 생성 실패");
                // CUR_PATH를 틀리게 작성하고 실행해 볼 것
                throw new RuntimeException(e);
            }
        }
        //  💡 File 인스턴스의 메소드들
        var file1Exist = file1.exists();
        var file1Name = file1.getName();
        var file1IsFile = file1.isFile(); // 파일인가 여부
        var file1IsDir = file1.isDirectory(); // 디렉토리인가 여부
        var file1Length = file1.length();

        var file1AbsPath = file1.getAbsolutePath(); // 절대경로
        var file1CnnPath = ""; // ⭐️ 완전 절대경로
        try {
            file1CnnPath = file1.getCanonicalPath();
        } catch (IOException e) {
            // 💡 파일의 읽기 권한이 없을 시
            throw new RuntimeException(e);
        }  // 🔴

        //  완전 절대경로로 파일 생성
        var file2 = new File(
                file1CnnPath.replace("file1.txt", "file2.txt")
        );
        try {
            boolean result = file2.createNewFile();
            //  💡 해당 이름의 파일이 있다면 예외를 발생시키지는 않고 false 반환
            System.out.println(result ? "파일 생성됨" : "이미 있음");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
