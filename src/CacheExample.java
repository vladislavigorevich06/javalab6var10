import java.util.Arrays;

public class CacheExample {

    private String[] cacheAreas;

    //конструктор для передачи областей
    public CacheExample(String... areas) {
        this.cacheAreas = areas;
    }

    //конструктор по умолч пустой массив
    public CacheExample() {
        this.cacheAreas = new String[0];
    }

    public String[] getCacheAreas() {
        return cacheAreas;
    }

    // метод для "имитации обращения к кэшу"
    public boolean accessCache(String area) {
        if (cacheAreas == null || cacheAreas.length == 0) return false;
        return Arrays.asList(cacheAreas).contains(area);
    }
}
