import java.lang.reflect.Method;

public class InvokeProcessor {

    public static void process(Object obj) throws Exception {
        for (Method m : obj.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(Invoke.class)) {
                m.setAccessible(true);
                m.invoke(obj);
            }
        }
    }
}
