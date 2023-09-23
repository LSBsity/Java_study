package sec13.chap04.ex03;

@Character
public class RobinHood {
    private Sword sword;

    @AutoMount
    private Arrow arrow;

    @AutoRun
    public void shootArrow () {
        System.out.printf(
                "%s가 %s를 쏩니다.%n",
                this.getClass().getSimpleName(),
                arrow.getClass().getSimpleName()
        );
    }
}
