@Cache({})
public class EmptyCacheExample {
    private String data = "Кэшируемые данные";

    public String[] getCacheAreas() {
        Cache annotation = this.getClass().getAnnotation(Cache.class);
        return annotation.value();
    }

    public String getData() { return data; }
}
