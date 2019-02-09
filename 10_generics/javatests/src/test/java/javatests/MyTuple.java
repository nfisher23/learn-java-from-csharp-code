package javatests;

class MyTuple<T> {

    // I don't recommend doing this in real code
    public static String globalStaticField;

    private final T first;

    private final T second;

    public MyTuple(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}