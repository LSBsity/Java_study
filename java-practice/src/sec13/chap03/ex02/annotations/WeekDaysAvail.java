package sec13.chap03.ex02.annotations;

import sec13.chap03.ex02.enums.WeekDay;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface WeekDaysAvail {
    WeekDay[] value();
}