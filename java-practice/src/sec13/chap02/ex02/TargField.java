package sec13.chap02.ex02;

import java.lang.annotation.*;

//@TargConstr // ⚠️ 사용불가
@Target(ElementType.FIELD)
public @interface TargField {
}