package sec03.chap05;

public class Ex05 {
    public static void main(String[] args) {
        String str1 = "문자열에 \"큰따옴표가\" 안 들어가요";
        String str2 = "엔터도 안 들어가요. 못 믿겠으면 넣어봐.";

        //  실행하여 확인
        String str = "문자열에 \"큰따옴표\"도,\n엔터도 넣을 수 있다고?";
        System.out.println(str);

        String table = "언어\t\t종류\t\t\t\t자료형\nJava\tcompiled\t\t정적\nPython\tinterpreted\t\t동적";
        System.out.println(table);

        char singleQuote = '\'';
        System.out.println(singleQuote);

        String path = "C:\\Document\\MyCodings";
        System.out.println(path);
    }
}
