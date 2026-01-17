import org.junit.Test;
import static org.junit.Assert.*;

public class ToStringTest {

    @Test
    public void testYesFieldsIncluded() throws Exception {
        ToStringExample obj = new ToStringExample("Alice", "12345", 25, "a@b.com");
        String result = obj.toCustomString();

        System.out.println("\n--- Тест: testYesFieldsIncluded ---");
        System.out.println("Результат toCustomString: " + result);

        boolean nameIncluded = result.contains("name=Alice");
        boolean passwordExcluded = !result.contains("password=12345");

        System.out.println("Проверка: поле name должно быть включено: " + nameIncluded);
        System.out.println("Проверка: поле password должно быть исключено: " + passwordExcluded);

        assertTrue(nameIncluded);
        assertTrue(passwordExcluded);
    }

    @Test
    public void testUnannotatedFieldIncluded() throws Exception {
        class Employee extends ToStringExample {
            String department = "HR";
            Employee(String name, String password, int age, String email) {
                super(name, password, age, email);
            }
        }

        Employee e = new Employee("Bob", "pass", 30, "b@c.com");
        String result = e.toCustomString();

        System.out.println("\n--- Тест: testUnannotatedFieldIncluded ---");
        System.out.println("Результат toCustomString: " + result);

        boolean departmentIncluded = result.contains("department=HR");
        System.out.println("Проверка: поле department (неаннотированное) должно быть включено: " + departmentIncluded);

        assertTrue(departmentIncluded);
    }
}
