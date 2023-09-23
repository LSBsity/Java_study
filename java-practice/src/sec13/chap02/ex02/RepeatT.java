package sec13.chap02.ex02;

import java.lang.annotation.*;

@Repeatable(Repeats.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatT {
    //  💡 다음 강에서 배움
    int a();
    int b();
}
