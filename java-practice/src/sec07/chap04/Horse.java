package sec07.chap04;

public class Horse<T extends Unit> {
    private int extraHp;
    private T rider;

    public Horse(int extraHp) {
        this.extraHp = extraHp;
    }

    public void setRider(T rider) {
        this.rider = rider;
        rider.hp += extraHp;
    }

    @Override
    public String toString() {
        return "말 (추가체력: %d)".formatted(extraHp);
    }
}