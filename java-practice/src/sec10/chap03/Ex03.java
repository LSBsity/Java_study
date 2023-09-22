package sec10.chap03;

public class Ex03 {
    public static void main(String[] args) {
        try {
            registerDutyMonth("김돌준", 13);
        } catch (WrongMonthException we) {
            we.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerDutyMonth(String name, int month) {
        if (month < 1 || month > 12) {
            throw new WrongMonthException(month);
        }
        System.out.printf("%s씨 %d월 담당으로 배정되셨어요.%n", name, month);
    }
}
