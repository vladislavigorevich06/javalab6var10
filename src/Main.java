import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== ДЕМОНСТРАЦИЯ АННОТАЦИЙ ===");
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Демонстрация @Invoke");
            System.out.println("2. Демонстрация @Default");
            System.out.println("3. Демонстрация @ToString");
            System.out.println("4. Демонстрация @Validate");
            System.out.println("5. Демонстрация @Two");
            System.out.println("6. Демонстрация @Cache");
            System.out.println("7. Запустить все демонстрации");
            System.out.println("0. Выход");
            System.out.println("=============");
            System.out.print("Выберите действие (0-7): ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0 -> { System.out.println("Выход"); return; }
                case 1 -> InvokeDemo.run();
                case 2 -> DefaultDemo.run();
                case 3 -> ToStringDemo.run(scanner);
                case 4 -> ValidateDemo.run();
                case 5 -> TwoDemo.run();
                case 6 -> CacheDemo.run();
                case 7 -> {
                    InvokeDemo.run();
                    DefaultDemo.run();
                    ToStringDemo.run(scanner);
                    ValidateDemo.run();
                    TwoDemo.run();
                    CacheDemo.run();
                }
                default -> System.out.println("Некорректный ввод");
            }
        }
    }
}
