package sec13.chap02.ex02;


import java.lang.annotation.*;

@Target({
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.LOCAL_VARIABLE
})
public @interface TargMulti { }