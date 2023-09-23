package sec13.chap03.ex02.classes;

import sec13.chap03.ex02.annotations.*;
import sec13.chap03.ex02.enums.*;

@ClassDesc("🏥 병원 예약")
public class Appointment {

    @Blind
    private String name;

    @WeekDaysAvail({WeekDay.MON, WeekDay.WED, WeekDay.FRI})
    private WeekDay day;

    @NumLimit(type = LimitType.MIN, to = 9)
    @NumLimit(type = LimitType.MAX, to = 17)
    private int startHour;

    @MaxLength(20)
    String symptom;

    public Appointment(
            String name, WeekDay day, int startHour, String symptom
    ) {
        this.name = name;
        this.day = day;
        this.startHour = startHour;
        this.symptom = symptom;
    }

    @TestAndPrint(before = "🕰️ 예약 내역을 출력합니다.")
    public void print() {
        System.out.printf(
                "%s님 %s요일 %d시%n",
                name, day.getName(), startHour
        );
    }
}