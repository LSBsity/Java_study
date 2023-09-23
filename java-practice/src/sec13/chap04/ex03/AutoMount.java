package sec13.chap04.ex03;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface AutoMount { }