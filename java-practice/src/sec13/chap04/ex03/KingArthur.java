package sec13.chap04.ex03;

@Character
public class KingArthur {
    @AutoMount
    private Sword sword;

    private Arrow arrow;

    @AutoRun
    public void swingSword() {
        System.out.printf(
                "%s가 %s를 휘두릅니다.%n",
                this.getClass().getSimpleName(),
                sword.getClass().getSimpleName()
        );
    }
}
