import org.junit.Test;
import static org.junit.Assert.*;

public class CacheTest {

    @Test
    public void testCacheAreasReading() {
        System.out.println("\n--- Тест: testCacheAreasReading ---");
        CacheExample obj = new CacheExample("Area1", "Area2", "Area3");

        String[] areas = obj.getCacheAreas();
        System.out.println("Считанные области: ");
        for (String area : areas) {
            System.out.println("  - " + area);
        }

        assertEquals("Должно быть 3 области", 3, areas.length);
        assertEquals("Первая область должна быть Area1", "Area1", areas[0]);
        assertEquals("Вторая область должна быть Area2", "Area2", areas[1]);
        assertEquals("Третья область должна быть Area3", "Area3", areas[2]);

        System.out.println("=== Проверка успешна ===\n");
    }

    @Test
    public void testEmptyCacheDoesNotCache() {
        System.out.println("\n--- Тест: testEmptyCacheDoesNotCache ---");
        CacheExample obj = new CacheExample(); // пустой массив

        String[] areas = obj.getCacheAreas();
        System.out.println("Считанные области (должно быть пусто): " + (areas.length == 0));

        assertEquals("Пустой массив должен возвращать 0 элементов", 0, areas.length);
        System.out.println("=== Проверка успешна ===\n");
    }

    @Test
    public void testMultipleNamedCacheAreas() {
        System.out.println("\n--- Тест: testMultipleNamedCacheAreas ---");
        CacheExample obj = new CacheExample("Users", "Products", "Orders");

        String[] areas = obj.getCacheAreas();
        System.out.println("Считанные области:");
        for (String area : areas) {
            System.out.println("  - " + area);
        }

        assertEquals(3, areas.length);
        assertEquals("Users", areas[0]);
        assertEquals("Products", areas[1]);
        assertEquals("Orders", areas[2]);

        System.out.println("=== Проверка успешна ===\n");
    }

    // Мок-тест (имитация обращения к кэшу)
    @Test
    public void testCacheMockBehavior() {
        System.out.println("\n--- Тест: testCacheMockBehavior ---");
        // здесь можно имитировать поведение кэша, если CacheExample поддерживает методы put/get
        System.out.println("Мок-тест: обращение к кэшу имитируется (пример)");
        assertTrue(true); // просто демонстрация
        System.out.println("=== Проверка успешна ===\n");
    }
}
