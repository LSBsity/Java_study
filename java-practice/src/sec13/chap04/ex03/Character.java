package sec13.chap04.ex03;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Character {
}
