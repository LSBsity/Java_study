package sec07.chap01.ex01;

public class Button {
    public enum Mode {
        LIGHT("라이트"), DARK("다크");

        Mode(String indicator) {
            this.indicator = indicator;
        }

        String indicator;
    }

    private String name;
    private Mode mode;
    private int spaces;

    public Button(String name, Mode mode, int spaces) {
        this.name = name;
        this.mode = mode;
        this.spaces = spaces;
    }

    //⭐️ 아래를 주석해제하고 다시 실행해 볼 것
    @Override
    public String toString() {
        return "%s %s버튼 (%d칸 차지)".formatted(mode.indicator, name, spaces);
    }
}
