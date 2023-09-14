package sec04.chap06;

public class Ex02 {
    //  ⭐️ 원시값은 '복사해서' 가져옴
    //  메소드 내부에서 값을 변경해도 원본에 영향 끼치지 않음
    static void modifyIntArg(int num) {
        System.out.printf("수정 전: %d%n", num++);
        System.out.printf("수정 후: %d%n", num);
    }

    //  ⭐️ 참조값은 주소값이므로 원본 그 자체를 가리킴
    static void modifyAryElem(int[] ary) {
        System.out.printf("수정 전: %d%n", ary[1]++);
        System.out.printf("수정 후: %d%n", ary[1]);
    }

    public static void main(String[] args) {
        int intNum = 3;
        modifyIntArg(intNum);

        int[] intNums = {1, 2, 3};

        //  배열은 참조형이지만 그 안의 값들은 원시형
        modifyIntArg(intNums[0]);

        //  참조형인 배열 자체를 인자로 사용
        modifyAryElem(intNums);
    }
}
