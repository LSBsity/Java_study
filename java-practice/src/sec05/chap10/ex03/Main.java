package sec05.chap10.ex03;

public class Main {
    public static void main(String[] args) {
        Tab tab1 = new Tab();
        Tab tab2 = new Tab();
        Tab tab3 = new Tab();

        System.out.println(tab1.getSetting().getVolume());
        System.out.println(tab2.getSetting().getVolume());
        System.out.println(tab3.getSetting().getVolume());

        System.out.println("\n- - - - -\n");

        tab1.getSetting().incVolume();
        tab1.getSetting().incVolume();

        System.out.println(tab1.getSetting().getVolume());
        System.out.println(tab2.getSetting().getVolume());
        System.out.println(tab3.getSetting().getVolume());

        //  🎉 외부에서 각 사용처들을 신경쓸 필요 없음
    }
}
