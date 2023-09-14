package sec03.chap08;

public class Ex02 {
    public static void main(String[] args) {
        //  초기화 블록을 사용한 선언 동시 초기화
        //  두 가지 방법 사용 가능
        char[] dirAry1 = {'동', '서', '남', '북'};
        char[] dirAry2 = new char[]{'동', '서', '남', '북'};

        char[] dirAry3;

        //  선언만 먼저 한 상태에서는 두 번째 방법만 가능
        //  dirAry3 = {'동', '서', '남', '북'}; // ⚠️ 불가
        dirAry3 = new char[]{'동', '서', '남', '북'};

        int[] intAry = {1, 2, 3, 4, 5};

        //  ⚠️ 런다임 에러: ArrayIndexOutOfBoundsException
        // int outOfAry = intAry[intAry.length];
    }
}
