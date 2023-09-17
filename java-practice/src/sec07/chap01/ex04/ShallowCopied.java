package sec07.chap01.ex04;

public class ShallowCopied implements Cloneable {
    String title;
    int no;

    int[] numbers;
    Click click;
    Click[] clicks;

    public ShallowCopied(String title, int no, int[] numbers, Click click, Click[] clicks) {
        this.title = title;
        this.no = no;
        this.numbers = numbers;
        this.click = click;
        this.clicks = clicks;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        //  Cloneable을 구현했으므로 정상 동작
        //  - 원시값만 완전히 복사됨
        return super.clone();
    }
}