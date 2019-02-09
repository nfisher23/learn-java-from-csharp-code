package javatests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ExampleTests {

    @Test
    public void notARealEquals() {
        Grandparent gp1 = new Grandparent();

        Object defNotAGrandpa = new Object();
        assertFalse(gp1.equals(defNotAGrandpa));
    }

    @Test
    public void testFieldInit() {
        ParentWithValue pair = new ChildWithValue();

        assertEquals("default child", pair.getValue());
    }
}
