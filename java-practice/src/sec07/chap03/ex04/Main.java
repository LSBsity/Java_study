package sec07.chap03.ex04;

public class Main {
    public static void main(String[] args) {
        FormClicker<Button> fc1 = new FormClicker<>(new Button());
        FormClicker<Switch> fc2 = new FormClicker<>(new Switch(true));

        fc1.printElemMode();
        fc2.clickElem();

        //  ⚠️ 조건에 부합하지 않는 클래스 사용 불가
//        FormClicker<TextInput> fc3 = new FormClicker<>(new TextInput());
//        FormClicker<HyperLink> fc4 = new FormClicker<>(new HyperLink());
    }
}
