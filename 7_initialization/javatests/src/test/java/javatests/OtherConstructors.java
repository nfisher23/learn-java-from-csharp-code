package javatests;

public class OtherConstructors {

    public OtherConstructors() {
        this("default value");
    }

    public OtherConstructors(String someString) {
        this.someString = someString;
    }

    private String someString;

    public String getSomeString() {
        return someString;
    }
}
