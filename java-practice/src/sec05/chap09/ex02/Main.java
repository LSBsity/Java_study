package sec05.chap09.ex02;

public class Main {
    public static void main(String[] args) {
        FoodSafety.announcement();

        YalcoChicken store1 = new YalcoChicken();

        store1.regularInspection();
        store1.cleanKitchen();
        store1.employeeEducation();
    }
}
