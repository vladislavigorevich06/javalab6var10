public class MyClass {

    public boolean method1Executed = false;
    public boolean method2Executed = false;
    public String result = "";

    @Invoke
    public void method1() {
        method1Executed = true;
        result += "Method1 ";
    }

    @Invoke
    public void method2() {
        method2Executed = true;
        result += "Method2 ";
    }
}
