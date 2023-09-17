package sec07.chap04;

public class Main {
    public static void main(String[] args) {
        Swordman r_swordman1 = new Swordman(Side.RED);
        Knight r_knight1 = new Knight(Side.RED);
        Knight r_knight2 = new Knight(Side.RED);
        MagicKnight r_magicKnight1 = new MagicKnight(Side.RED);

        Knight b_knight1 = new Knight(Side.BLUE);
        MagicKnight b_magicKnight1 = new MagicKnight(Side.BLUE);
        MagicKnight b_magicKnight2 = new MagicKnight(Side.BLUE);

        Horse<Swordman> avante = new Horse<>(40);
        Horse<Knight> sonata = new Horse<>(50);

        avante.setRider(r_swordman1); // 🔴
        sonata.setRider(b_magicKnight1);

        r_swordman1.defaultAttack(b_knight1); // 🔴
        r_knight1.defaultAttack(b_magicKnight1);
        r_knight2.switchWeapon();
        r_knight2.defaultAttack(b_magicKnight2);

        b_magicKnight1.defaultAttack(r_swordman1);
        b_magicKnight2.lighteningAttack(new Unit[]{
                r_knight1,
                r_knight2,
                r_magicKnight1
        });
    }
}
