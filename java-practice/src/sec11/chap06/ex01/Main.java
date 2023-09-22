package sec11.chap06.ex01;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        //  💡 쓰레드풀을 관리하는 라이브러리 클래스
        ExecutorService es = Executors.newFixedThreadPool(
                //  💡 동시에 일할 수 있는 지원자의 수
                //  - 숫자를 바꿔 볼 것
                5);
        Cave cave = new Cave();
        while (cave.getWater() > 20) {
            //  💡 execute : Runnable(지원자)을 대기열에 추가
            es.execute(new VolunteerRun(cave));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
        //  💡 shutdown : 풀 닫기 (투입 중단, 더 투입시 예외)
        //  - ⭐ 이를 생략하면 프로그램이 끝나지 않음
        //  - 일단 들어간 지원자는 자리가 날 때까지 기다리다 일 함
        //es.shutdown();
        //es.execute(new VolunteerRun(cave)); // ⚠️ 닫혔으므로 예외 발생

        //  💡 shutdownNow : 풀 닫고 투입된 지원자 해산, 진행중인 업무 강제종료
        //  - ⚠️ 진행중인 업무 강제종료는 보장하지 않음
        //    - 각 쓰레드에 InterruptedException을 유발할 뿐
        //    - 각 Runnable에서 해당 예외 발생시 종료되도록 처리해주어야 함
        //  - 투입되어 대기중인 지원자들은 리스트 형태로 반환
        List<Runnable> waitings = es.shutdownNow();
        System.out.println(waitings);
    }
}
