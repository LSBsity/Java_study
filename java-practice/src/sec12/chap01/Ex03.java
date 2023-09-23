package sec12.chap01;

import java.io.*;
import java.util.stream.*;

public class Ex03 {
    public static void main(String[] args) {
        var folderName = "myFolder";
        File folder = new File(Ex01.CUR_PATH + folderName);

        //  💡 디렉토리 만들기
        boolean folderMade = folder.mkdir();
        boolean isFile = folder.isFile();
        boolean isDir = folder.isDirectory();

        IntStream.range(0, 10).forEach(i -> {
            try {
                if (i % 3 == 0) {
                    new File(
                            "%s%s/folder%d"
                                    .formatted(Ex01.CUR_PATH, folderName, i + 1)
                    ).mkdir();
                    return;
                }
                new File(
                        "%s%s/file%d.txt"
                                .formatted(Ex01.CUR_PATH, folderName, i + 1)
                ).createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //  💡 폴더 안의 파일/폴더들 배열로 출력
        File[] filesInFolder = folder.listFiles();
        String[] fileNamesInFolder = folder.list();

    }
}
