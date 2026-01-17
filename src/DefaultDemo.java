public class DefaultDemo {

    public static void run() throws Exception {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ @Default ===");

        System.out.println("Аннотация на классе DefaultExample:");
        DefaultProcessor.process(DefaultExample.class);
    }
}
