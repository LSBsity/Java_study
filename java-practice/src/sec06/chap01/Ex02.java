package sec06.chap01;

public class Ex02 {
    public static void main(String[] args) {
        //System.out.println(a); // ⚠️ 클래스 메소드에서 인스턴스 필드 사용 불가
    }

    //private String y = x; // ⚠️ 클래스 내 필드의 스코프 : 해당 클래스 안
    private int a = 1;
    private int b = a + 1;
    //private int c = d + 1; // ⚠️ 메소드 내 변수의 스코프 : 해당 메소드 안

    public void func1() {
        System.out.println(a + b);
        int d = 2;
    }

    public void func2() {
        //System.out.println(d); // ⚠️
    }
}
