public class TwoProcessor {

    public static void process(Class<?> cls) {
        Two ann = cls.getAnnotation(Two.class);
        if (ann != null) {
            System.out.println("first: " + ann.first());
            System.out.println("second: " + ann.second());
        }
    }
}
