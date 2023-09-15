package sec05.chap08.ex01;

public abstract class YalcoGroup {
    protected static final String CREED = "우리의 %s 얄팍하다";

    //  💡 클래스 메소드는 abstract 불가
    //  abstract static String getCreed ();

    protected final int no;
    protected final String name;

    public YalcoGroup(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public String intro() {
        return "%d호 %s점입니다.".formatted(no, name);
    }

    //  이후 다른 패키지에서의 실습을 위해 public으로
    public abstract void takeOrder();
}
