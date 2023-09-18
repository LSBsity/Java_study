package sec09.chap01;

@FunctionalInterface
public interface Printer {
    void print();

    //  void say (); // ⚠️ 둘 이상의 메소드는 불가
}
