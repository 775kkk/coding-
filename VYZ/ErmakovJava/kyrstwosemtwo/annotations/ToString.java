package VYZ.ErmakovJava.kyrstwosemtwo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {

    Mode value() default Mode.YES;

    enum Mode {
        YES,
        NO
    }
}
