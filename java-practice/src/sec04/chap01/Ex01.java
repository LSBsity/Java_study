package sec04.chap01;

public class Ex01 {
    public static void main(String[] args) {
        boolean open = true;
        int saleFrom = 10, saleTo = 20;
        int today = 15;

        //  💡 if : 괄호 안의 boolean 값이 true면 다음 명령 실행
        if (open) System.out.println("영업중");
        if (!open) System.out.println("영업종료");

        //  💡 실행할 명령이 한 줄 이상일 경우 블록 사용
        if (today >= saleFrom && today <= saleTo) {
            System.out.println("세일중입니다.");
            System.out.println("전품목 20% 할인");
        }
        //  💡 else : if문 안의 boolean 값이 false일 경우 실행
        if (open) {
            System.out.println("영업중");
        } else {
            System.out.println("영업종료");
        }
    }
}
