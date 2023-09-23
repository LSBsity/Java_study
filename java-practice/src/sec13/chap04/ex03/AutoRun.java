package sec13.chap04.ex03;

import java.lang.annotation.*;

@Target(java.lang.annotation.ElementType.METHOD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface AutoRun { }