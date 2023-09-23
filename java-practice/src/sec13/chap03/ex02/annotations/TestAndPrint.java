package sec13.chap03.ex02.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAndPrint {
    String before() default "";

    String after() default "";
}