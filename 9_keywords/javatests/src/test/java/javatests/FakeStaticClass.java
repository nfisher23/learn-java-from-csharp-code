package javatests;

final class FakeStaticClass {
    private FakeStaticClass() { throw new RuntimeException("this is to prevent reflection techniques from accessing it"); }

    public static void someStaticMethod() { }
}
