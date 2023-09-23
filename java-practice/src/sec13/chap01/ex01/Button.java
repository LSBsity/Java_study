package sec13.chap01.ex01;

public class Button extends FormElement implements Clickable, Hoverable {
    public static int lastNo = 0;
    private int no = ++lastNo;
    private String name;
    private int spaces = 2;
    public boolean disabled = false;

    public Button() {
        name = "Default";
        spaces = 1;
    }
    public Button(String name, int spaces) {
        this.name = name;
        this.spaces = spaces;
    }

    public int getNo() { return no; }

    public String getName() { return name; }

    public int getSpaces() { return spaces; }

    public void onClick (boolean rightClick, int x, int y) {
        System.out.printf(
                "🖱️ %s (%d, %d)%n",
                (rightClick ? "우클릭" : "좌클릭"), x, y
        );
    }
}