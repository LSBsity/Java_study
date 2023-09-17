package sec07.chap03.ex04;

public class Button extends FormElement implements Clickable {
    @Override
    public void onClick() {
        func();
    }

    @Override
    void func() {
        System.out.println("버튼 클릭");
    }
}