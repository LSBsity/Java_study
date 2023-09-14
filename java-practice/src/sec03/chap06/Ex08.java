package sec03.chap06;

public class Ex08 {
    public static void main(String[] args) {
        String str_a1 = "덜컹";

        // 💡 repeat : 문자열을 주어진 정수만큼 반복
        String str_a2 = str_a1.repeat(2);
        String str_a3 = str_a1
                .concat(" ")
                .repeat(3)
                .trim();

        String str_b1 = "대한민국 다 job 구하라 그래";

        //  💡 substring : ~번째 문자부터 (~번째 문자까지) 잘라서 반환
        String str_b2 = str_b1.substring(7);
        String str_b3 = str_b1.substring(7, 10);
        String str_b4 = str_b1.substring(11, 14);

        String piece1 = "다 ";
        String piece2 = "구하라";
        String str_b5 = str_b1.substring(
                str_b1.indexOf(piece1),
                str_b1.indexOf(piece2) + piece2.length()
        );

        //  💡 replace : 주어진 앞의 문자(열)을 뒤의 문자(열)로 치환
        String str_c1 = "점심에 보쌈집에 가서 수육을 먹었다.";
        String str_c2 = str_c1.replace("보쌈", "중국");

        //  여럿 포함시 모두 치환
        String str_c3 = "밥 좀 먹자, 응? 야, 밥 좀 먹자고 밥 밥 밥";
        String str_c4 = str_c3.replace('밥', '빵');

        // ⭐️ 원본은 바뀌지 않는 점 확인

        //  메서드 체이닝
        String str_d1 = "하여튼 호의가 반복되면 권리인 줄 알아";
        String str_d2 = str_d1
                .replace("하여튼", "아무튼")
                .replace("호의", "호이".repeat(2))
                .replace("권리", "아기공룡 둘리");

        String str_e1 = "02=123.4567_8900";

        //  💡 replaceAll / replaceFirst : ⭐️ 정규표현식 사용 가능
        //  전부 치환 / 첫 번째 일치부분만 치환
        String str_e2 = str_e1
                .replaceAll("[=._]", "-")
                .replaceFirst("[-@#]", ")");
    }
}
