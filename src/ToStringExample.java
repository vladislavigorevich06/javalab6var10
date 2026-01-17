public class ToStringExample {

    @ToString(ToString.Mode.YES)
    private String name;

    @ToString(ToString.Mode.NO)
    private String password;

    @ToString(ToString.Mode.YES)
    private int age;

    @ToString(ToString.Mode.YES)
    private String email;

    public ToStringExample(String name, String password, int age, String email) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.email = email;
    }

    // Геттеры
    public String getName() { return name; }
    public String getPassword() { return password; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    public boolean isPasswordHidden() {
        try {
            return this.getClass()
                    .getDeclaredField("password")
                    .getAnnotation(ToString.class)
                    .value() == ToString.Mode.NO;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    public String toCustomString() throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("{");

        for (var field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            ToString ann = field.getAnnotation(ToString.class);
            if (ann != null && ann.value() == ToString.Mode.NO) continue;

            sb.append(field.getName())
                    .append("=")
                    .append(field.get(this))
                    .append(", ");
        }

        if (sb.lastIndexOf(", ") > 0)
            sb.delete(sb.lastIndexOf(", "), sb.length());

        sb.append("}");
        return sb.toString();
    }
}
