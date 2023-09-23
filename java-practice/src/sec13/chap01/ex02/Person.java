package sec13.chap01.ex02;

public class Person {
    private static int lastNo = 0;
    private int no;
    private String name;
    private int age;
    private double height;
    private boolean married;

    public Person(String name, int age, double height, boolean married) {
        this.no = ++lastNo;
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
    }

    public int getNo() { return no; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getHeight() { return height; }
    public boolean isMarried() {return married;}

    @Override
    public String toString() {
        return "%s (%d세 %s) : %.2fcm"
                .formatted(
                        name,
                        age,
                        (married ? "기혼" : "미혼"),
                        height
                );
    }
}
