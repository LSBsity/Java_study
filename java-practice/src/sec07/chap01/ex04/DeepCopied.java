package sec07.chap01.ex04;

public class DeepCopied implements Cloneable {
    String title;
    int no;

    int[] numbers;
    Click click;
    Click[] clicks;

    public DeepCopied(String title, int no, int[] numbers, Click click, Click[] clicks) {
        this.title = title;
        this.no = no;
        this.numbers = numbers;
        this.click = click;
        this.clicks = clicks;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        //  원시값들 복사
        DeepCopied clone = (DeepCopied) super.clone();

        //  ⭐️ 참조타입의 복사
        //  - 원시값 요소들을 하나하나 복사해 넣음

        clone.numbers = new int[numbers.length];
        for (var i = 0; i < numbers.length; i++) {
            clone.numbers[i] = numbers[i];
        }

        clone.click = new Click(click.x, click.y);

        //  이중 참조 (인스턴스의 배열)
        //  - 이중으로 복사
        clone.clicks = new Click[clicks.length];
        for (var i = 0; i < clicks.length; i++) {
            clone.clicks[i] = new Click(clicks[i].x, clicks[i].y);
        }

        return clone;
    }
}