package javatests;

public class Parent extends Grandparent {
    @Override
    public String someMethod() {
        return "parent string";
    }

    @Override
    public void changeMember() {
        super.changeMember();
    }
}
