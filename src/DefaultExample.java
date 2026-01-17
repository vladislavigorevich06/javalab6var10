@Default(String.class)
public class DefaultExample {

    public Object number;

    public DefaultExample() throws Exception {
        Class<?> cls = this.getClass().getAnnotation(Default.class).value();
        this.number = cls.getDeclaredConstructor().newInstance();
        if (number instanceof String) {
            number = "42";
        }
    }
}
