public class DefaultProcessor {

    public static void process(Class<?> cls) throws Exception {
        Default ann = cls.getAnnotation(Default.class);
        if (ann != null) {
            System.out.println(ann.value().getName());
            Object obj = ann.value().getDeclaredConstructor().newInstance();
        }
    }
}
