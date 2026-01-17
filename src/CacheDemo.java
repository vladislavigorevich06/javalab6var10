public class CacheDemo {

    public static void run() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ @Cache ===");

        System.out.println("Аннотация на классе CacheExample:");
        CacheProcessor.process(CacheExample.class);

        System.out.println("\nАннотация на классе EmptyCacheExample:");
        CacheProcessor.process(EmptyCacheExample.class);
    }
}
