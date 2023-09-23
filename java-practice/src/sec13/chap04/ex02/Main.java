package sec13.chap04.ex02;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //  💡 ClassLoader 인스턴스를 가져오는 방법들

        //  Class의 메소드로 가져옴
        ClassLoader loader1 = Main.class.getClassLoader();
        //  실행중인 쓰레드의 메소드로 가져옴
        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        //  ClassLoader의 정적 메소드로 가져옴
        ClassLoader loader3 = ClassLoader.getSystemClassLoader();

        //  💡 모두 동일
        var areSame1 = loader1 == loader2;
        var areSame2 = loader2 == loader3;

        Class<?> noUseCls1 = NoUse.class;
        //  💡️ 아래 둘은 모두 ClassNotFoundException을 던짐
        Class<?> noUseCls2 = Class.forName("sec13.chap04.ex02.NoUse");
        Class<?> noUseCls3 = loader1.loadClass("sec13.chap04.ex02.NoUse");
        //  ☝️ 클래스로더를 사용하여 가져온 클래스
        //  - ⭐️ Class.forName 메소드 내부에 클래스로더가 사용됨 확인

        //  💡 모두 동일
        var areSame3 = noUseCls1 == noUseCls2;
        var areSame4 = noUseCls2 == noUseCls3;
    }
}
