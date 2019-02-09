package javatests;

class ChildWithValue extends ParentWithValue {
    String value = "default child";

    @Override
    public String getValue() {
        return value;
    }
}


