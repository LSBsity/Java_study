package sec07.chap03.ex04;

public class Switch extends FormElement implements Clickable {
    private boolean isOn;

    public Switch(boolean isOn) {
        this.isOn = isOn;
    }

    @Override
    public void onClick() {
        func();
    }

    @Override
    void func() {
        isOn = !isOn;
        System.out.printf("%s(으)로 전환%n", isOn ? "ON" : "OFF");
    }
}