package sec11.chap06.ex01;

public class VolunteerRun implements Runnable {
    private static int lastNo = 0;
    private static int working = 0;

    private int no;
    private Cave cave;

    public VolunteerRun(Cave cave) {
        this.no = ++lastNo;
        this.cave = cave;

        System.out.printf("🦺 %d번 지원자 투입 (남은 물 양: %d)%n", no, cave.getWater());
    }

    @Override
    public void run() {
        working++;
        System.out.printf("🪣 %d번 지원자 시작 (현재 %d명 펌핑중, 남은 물 %d)%n", no, working, cave.getWater());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //  💡 아래의 return이 없다면 shutdownNow를 해도 중단되지 않음
            //  - 주석해제하고 shutdownNow 버전으로 다시 실행해 볼 것
            working--;
            System.out.printf(
                    "🛑 %d번 지원자 중단 (현재 %d명 펌핑중, 남은 물 %d)%n",
                    no, working, cave.getWater()
            );
            return;
        }

        cave.pump();
        working--;
        System.out.printf("✅ %d번 지원자 완료 (현재 %d명 펌핑중, 남은 물 %d)%n", no, working, cave.getWater());
    }
}
