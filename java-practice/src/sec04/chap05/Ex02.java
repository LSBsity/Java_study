package sec04.chap05;

public class Ex02 {
    static int add(int num1, int num2) {
        return num1 + num2;
    }

    static boolean checkIfContain(String text, String token) {
        return text.toLowerCase().contains(token.toLowerCase());
    }

    public static void main(String[] args) {
        //  ⭐️ 반환한다는 것: 바꿔 쓸 수 있다는 것
        //  메서드 실행문을 메서드의 반환값으로 치환
        int int1 = add(2, 3);
        System.out.println(int1);

        System.out.println(add(4, 5));

        int int2 = add(add(6, 7), add(8, 9));
        System.out.println(int2);

        System.out.println("\n- - - - -\n");

        if (checkIfContain("Hello World", "hello")) {
            System.out.println("포함됨");
        } else {
            System.out.println("포함 안 됨");
        }

        System.out.println(checkIfContain("Hello World", "hello") ? "포함됨" : "포함 안 됨");
    }
}
