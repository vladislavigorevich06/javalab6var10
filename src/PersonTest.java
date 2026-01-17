import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {  // можно оставить имя PersonTest, главное, чтобы он компилировался

    @Test
    public void testToCustomString_includesYesFields() throws Exception {
        // Используем класс ToStringExample вместо Person
        ToStringExample obj = new ToStringExample("Alice", "12345", 25, "alice@mail.com");
        String result = obj.toCustomString();

        // Проверяем, что поле name (YES) есть в строке
        assertTrue(result.contains("name=Alice"));
        // Проверяем, что поле password (NO) отсутствует
        assertFalse(result.contains("password=12345"));
        // Проверяем, что остальные поля без аннотации присутствуют
        assertTrue(result.contains("age=25"));
        assertTrue(result.contains("email=alice@mail.com"));
    }

    @Test
    public void testToCustomString_includesUnannotatedFields() throws Exception {
        // Внутренний класс для проверки unannotated поля
        class Employee extends ToStringExample {
            String department = "HR"; // поле без аннотации
            Employee(String name, String password, int age, String email) {
                super(name, password, age, email);
            }
        }

        Employee e = new Employee("Bob", "0000", 30, "bob@mail.com");
        String result = e.toCustomString();

        // unannotated поле department должно отображаться
        assertTrue(result.contains("department=HR"));
    }
}
