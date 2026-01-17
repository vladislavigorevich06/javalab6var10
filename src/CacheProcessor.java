public class CacheProcessor {

    public static void process(Class<?> cls) {
        Cache ann = cls.getAnnotation(Cache.class);
        if (ann != null && ann.value().length > 0) {
            for (String s : ann.value()) {
                System.out.println("  - " + s);
            }
        } else {
            System.out.println("Список кешируемых областей пуст");
        }
    }
}
