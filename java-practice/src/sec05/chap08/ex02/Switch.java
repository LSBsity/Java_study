package sec05.chap08.ex02;

public class Switch extends FormElement {
    private boolean on;

    public Switch(int space, boolean on) {
        super(space);
        this.on = on;
    }

    @Override
    void func() {
        on = !on;
        System.out.println((on ? "ON" : "OFF") + "으로 전환");
    }
}
