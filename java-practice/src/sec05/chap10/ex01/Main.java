package sec05.chap10.ex01;

public class Main {
    public static void main(String[] args) {
        Tab tab1 = new Tab();
        Tab tab2 = new Tab();
        Tab tab3 = new Tab();

        System.out.println(tab1.getSetting().getVolume());

        System.out.println("\n- - - - -\n");

        tab1.getSetting().incVolume();
        tab1.getSetting().incVolume();

        System.out.println(tab1.getSetting().getVolume());

        //  ⚠️ 각 인스턴스는 서로 다른 Setting 인스턴스를 가짐
        //  - 설정값이 공유되지 못함
        System.out.println(tab2.getSetting().getVolume());
        System.out.println(tab3.getSetting().getVolume());
    }
}
