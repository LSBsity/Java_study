package sec04.chap01;

public class Ex04 {
    public static void main(String[] args) {
        int score = 85;
        //  ⭐ 보다 가독성 좋은 방식
        //  return문: 해당 메소드를 종료하고 빠져나옴
        if (score > 90) {
            System.out.println('A');
            return;
        }
        if (score > 80) {
            System.out.println('B');
            return;
        }
        if (score > 70) {
            System.out.println('C');
            return;
        }
        if (score > 60) {
            System.out.println('D');
            return;
        }
        System.out.println('F');
    }
}
