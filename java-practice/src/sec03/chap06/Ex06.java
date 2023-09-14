package sec03.chap06;

public class Ex06 {
    public static void main(String[] args) {
        String str_a1 = "Hello, World!";

        // 💡 toUpperCase / toLowerCase : 모두 대문자/소문자로 변환
        String str_a2 = str_a1.toUpperCase();
        String str_a3 = str_a1.toLowerCase();

        String str_b1 = "Hi! How are you? I'm fine. Thank you!";
        String str_b2 = "how";

        boolean bool_b1 = str_b1.contains(str_b2);

        //  ⭐️ 영문 텍스트에서 대소문자 무관 특정 텍스트 포함 여부 확인시
        boolean bool_b2 = str_b1
                .toUpperCase()
                .contains(str_b2.toUpperCase());

        boolean bool_b3 = str_b1
                .toLowerCase()
                .contains(str_b2.toLowerCase());
    }
}
