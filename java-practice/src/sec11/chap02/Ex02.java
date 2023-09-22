package sec11.chap02;

public class Ex02 {
    public static void main(String[] args) {
        Thread thr0 = new Thread(new PrintThrNoRun(0));
        Thread thr1 = new Thread(new PrintThrNoRun(1));
        Thread thr2 = new Thread(new PrintThrNoRun(2));

        //  💡 쓰레드의 우선순위 정하기
        //  - 기본적으로는 같은 우선권을 갖고 있음 (랜덤 결과)
        //      - 메인에서 상속받아 기본 5
        //  - 아래의 그룹들을 각각 활성화하여 다시 실행해 볼 것
        //      - ⚠️ 너무 기대는 말 것 (응?)

        //  💡 각 값이 1~10의 정수임 확인
        //  - 클수록 우선순위가 높음
        //thr0.setPriority(Thread.MIN_PRIORITY);
        //thr1.setPriority(Thread.NORM_PRIORITY);
        //thr2.setPriority(Thread.MAX_PRIORITY);

        //thr0.setPriority(Thread.MAX_PRIORITY);
        //thr1.setPriority(Thread.NORM_PRIORITY);
        //thr2.setPriority(Thread.MIN_PRIORITY);

        //  ⭐️ JVM에게 힌트만 줄 뿐... 실제 컨트롤은 OS가 함
        //  - 우선순위를 정해줘도 OS가 무시하면 그만임
        //  - 빈도에 살짝 영향? 국민청원/국민제안 정도로 기대

//        thr0.start();
//        thr1.start();
//        thr2.start();

        //  위의 start들을 주석처리하고 실행
        //  💡 yield : 같은 우선순위일 시 다른 쓰레드에 양보

        new Thread(() -> {
            for (var i = 0; i < 20; i++) {
                System.out.print(3);
                for (var j = 0; j < Integer.MAX_VALUE; j++) {}

                Thread.yield(); // ⭐
            }
        }).start();

        for (var i = 0; i < 20; i++) {
            System.out.print('M');
            for (var j = 0; j < Integer.MAX_VALUE; j++) {}
        }
        //  ⭐ yield 역시 힌트만 줄 뿐 결정은 OS가 내림
        //  - 환경과 상황마다 무의미할 수도


    }
}
