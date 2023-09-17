package sec07.chap03.ex04;

public class FormClicker<T extends FormElement & Clickable> {
    private T formElem;

    public FormClicker(T formElem) {
        this.formElem = formElem;
    }

    //  ⭐️ 조건의 클래스와 인터페이스의 기능 사용 가능
    //  - 자료형의 범위를 특정해주므로
    public void printElemMode() {
        formElem.printMode();
    }

    public void clickElem() {
        formElem.onClick();
    }
}