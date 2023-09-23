package sec13.chap02.ex02;

import java.lang.annotation.*;

@TargAnnot // ⭐️
@Target(ElementType.CONSTRUCTOR)
public @interface TargConstr {
}
