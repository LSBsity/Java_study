package sec13.chap03.ex02.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NumLimits {
    NumLimit[] value();
}