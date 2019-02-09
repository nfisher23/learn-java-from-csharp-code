package javatests;

public class Grandparent {
    public String someMethod() {
        return "grandparent string";
    }

    // wrong equals method overriden, not caught cuz no @Override
    // hmmm....
    public boolean equals(Grandparent gp) {
        return true; // always true
    }

    // this is the proper equals method
//    @Override
//    public boolean equals(Object gp) {
//        return true; // always true
//    }

    public void changeMember() {

    }
}