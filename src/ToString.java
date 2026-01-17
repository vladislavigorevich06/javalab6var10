import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {
    Mode value() default Mode.YES;

    // enum должен быть public
    public enum Mode {
        YES,
        NO
    }
}
