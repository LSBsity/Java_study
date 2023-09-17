package sec07.chap01.ex04;

public class Main {
    public static void main(String[] args) {
        DeepCopied deepCopied = new DeepCopied(
                "클릭들 1", 1, new int[]{1, 2, 3},
                new Click(12, 34),
                new Click[]{new Click(12, 34), new Click(56, 78)}
        );

        DeepCopied clone3 = null;
        try {
            clone3 = (DeepCopied) deepCopied.clone();
        } catch (CloneNotSupportedException e) {
            //  오류가 나지 않으므로 실행되지 않음
            System.out.printf("⚠️ 복제중 오류 발생 : %s%n", deepCopied);
        }

        deepCopied.title = "제목 바뀜";
        deepCopied.no = 2;
        deepCopied.numbers[0] = 0;
        deepCopied.click.x = 99;
        deepCopied.clicks[0].x = 99;
    }
}
