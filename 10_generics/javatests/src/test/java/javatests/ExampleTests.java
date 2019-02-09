package javatests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTests {

    @Test
    public void testTypeErasure() {
        MyTuple<Integer> intTuple = new MyTuple<>(1,2);
        MyTuple<String> stringTuple = new MyTuple<>("first","second");

        assertEquals(intTuple.getClass(), stringTuple.getClass()); // hmmmm...
    }

    @Test
    public void staticFields() {
        MyTuple<Integer> intTuple = new MyTuple<>(1,2);
        intTuple.globalStaticField = "int tuple set";
        MyTuple<String> stringTuple = new MyTuple<>("first", "second");
        stringTuple.globalStaticField = "string tuple set";

        assertEquals("string tuple set", intTuple.globalStaticField);
    }

}
