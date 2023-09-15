package sec05.chap05.ex03;

public class Main {
    public static void main(String[] args) {
        Slime slime = new Slime();
        FireSlime fireSlime = new FireSlime();

        slime.attack(fireSlime); // ⭐ 클래스가 다른데 가능한 이유 : 다음 강에서
        fireSlime.attack(slime);
    }
}
