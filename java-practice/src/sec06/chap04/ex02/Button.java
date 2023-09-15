package sec06.chap04.ex02;

public class Button {
    String name;

    public Button(String name) {
        this.name = name;
    }

    //  ⭐️ 인터페이스를 상속한 클래스 자료형
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void func() {
        onClickListener.onClick();
    }
}
