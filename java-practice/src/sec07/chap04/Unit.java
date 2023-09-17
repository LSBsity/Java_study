package sec07.chap04;

public abstract class Unit {

    //  ⚠️ 이후 실습의 편의를 위해 일부 필드를 public으로
    //  - 실무에서는 private로 만들고 getter/setter 권장
    public Side side;
    public int hp;

    public Unit(Side side, int hp) {
        this.side = side;
        this.hp = hp;
    }

    public Side getSide() {
        return side;
    }
}