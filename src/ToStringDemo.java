import java.util.Scanner;

public class ToStringDemo {

    public static void run(Scanner scanner) {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ @ToString ===");

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        ToStringExample obj = new ToStringExample(name, password, age, email);

        System.out.println("\nСоздан объект:");
        System.out.println("  name: " + obj.getName());
        System.out.println("  password: " + obj.getPassword());
        System.out.println("  age: " + obj.getAge());
        System.out.println("  email: " + obj.getEmail());

        System.out.println("\nСтроковое представление с учетом аннотации @ToString:");
        try {
            System.out.println(obj.toCustomString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nПоле password скрыто: " + obj.isPasswordHidden());
    }
}
