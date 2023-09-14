package sec03.chap04;

public class Ex04 {
    public static void main(String[] args) {
        int num1 = 3, num2 = 4;

        char num1OE = num1 % 2 == 1 ? '홀' : '짝';
        char num2OE = num2 % 2 == 1 ? '홀' : '짝';

        int num = 3;

        //  아래 값들을 바꿔가며 실행해 볼 것
        boolean mult2 = true;
        //mult2 = false;

        boolean plus5 = true;
        //plus5 = false;

        System.out.println(
                (!mult2 && !plus5) ? num
                        : (mult2 && plus5) ? num * 2 + 5
                        : mult2 ? num * 2
                        : num + 5
        );

        int x = 1, y = 2;

        //  💡 단축평가 적용됨
        int changed1 = x < y ? (x += 2) : (y += 2);
        int changed2 = x < y ? (x += 2) : (y += 2); // 🔴
        int changed3 = x < y ? (x += 2) : (y += 2);
        int changed4 = x < y ? (x += 2) : (y += 2);
        int changed5 = x < y ? (x += 2) : (y += 2);
    }
}
