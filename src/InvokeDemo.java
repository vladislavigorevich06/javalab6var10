public class InvokeDemo {
    public static void run() throws Exception {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ @Invoke ===");
        MyClass obj = new MyClass();
        System.out.println("До вызова: method1=" + obj.method1Executed + ", method2=" + obj.method2Executed);
        InvokeProcessor.process(obj);
        System.out.println("После вызова: method1=" + obj.method1Executed + ", method2=" + obj.method2Executed);
    }
}
