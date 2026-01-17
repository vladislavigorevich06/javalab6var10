public class ValidateDemo {

    public static void run() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ @Validate ===");

        System.out.println("Аннотация на классе ValidateExample:");
        ValidateProcessor.process(ValidateExample.class);

        System.out.println("\nПопытка обработать класс с пустым массивом:");
        ValidateProcessor.process(EmptyValidateExample.class);
    }
}
