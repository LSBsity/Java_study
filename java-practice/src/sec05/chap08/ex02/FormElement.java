package sec05.chap08.ex02;

public abstract class FormElement {
    protected int space;

    public FormElement(int space) {
        this.space = space;
    }

    abstract void func();
}
