package sec05.chap05.ex02;

public class ShutDownButton extends Button {
    public ShutDownButton() {
        super("ShutDown"); // 💡 부모의 생성자 호출
    }

    //  💡 부모의 메소드를 override
    @Override // Override를 붙이면 부모에게 없는 메서드를 못 씀
    public void func() {
        System.out.println("프로그램 종료");
    }
}