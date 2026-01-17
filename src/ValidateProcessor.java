public class ValidateProcessor {

    public static void process(Class<?> cls) {
        Validate ann = cls.getAnnotation(Validate.class);
        if (ann != null) {
            if (ann.value().length == 0) {
                System.out.println("Пустой список классов");
            } else {
                for (Class<?> c : ann.value()) {
                    System.out.print(c.getName() + " ");
                }
            }
            System.out.println();
        }
    }
}
