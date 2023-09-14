package sec02.chap03;

public class Ex04 {
    public static void main(String[] args) {
        // 💡 쉼표를 사용하여 여럿을 한 줄에 선언 및 초기화 가능
        // 모두 같은 자료형으로 선언됨

        char ch1, ch2, ch3; // 선언만

        char ch4 = 'A', ch5 = 'B', ch6 = 'C'; // 초기화까지

        // ⚠️  같은 변수를 두 번 선언하는 것 불가
        int number = 1;
        //int number = 2;

        //  ⚠️  변수를 선언 & 초기화하기 전 사용 불가
        //System.out.println(letter);

        char letter = 'A';

        System.out.println(letter);

        int numberA = 1;

        // 주머니의 값을 다른 주머니에 넣기
        int numberB = numberA;

        //  💡 원시타입 데이터는 값을 복사해서 줌
        //  이후 참조타입과 비교하여 자세히 다룰 것
        numberA = 2;
    }
}
