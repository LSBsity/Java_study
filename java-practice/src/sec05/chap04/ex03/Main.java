package sec05.chap04.ex03;

public class Main {
    public static void main(String[] args) {
        Product ballPen = new Product("볼펜", 1000);

        ballPen.setName("삼색볼펜");
        ballPen.setName("");

        int ballPenPrice = ballPen.getPrice();

        ballPen.setPrice(1500);
    }
}
