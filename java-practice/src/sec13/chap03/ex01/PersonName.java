package sec13.chap03.ex01;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface PersonName {
    String first();
    String last();
}
