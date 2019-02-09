package javatests;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ExampleTests {

    @Test
    public void cantCallToStringInJava() {
        int someValueAsInt = 10;
        String someValueAsString = Integer.toString(someValueAsInt);
        assertEquals("10", someValueAsString);
    }

    @Test
    public void objectWrappers() {
        Integer canBeNull = 40;

        canBeNull = null;

        assertNull(canBeNull);
    }

    @Test
    public void testRestEnum() {
        RestMethod aGetMethod1 = RestMethod.GET;
        RestMethod aGetMethod2 = RestMethod.GET;

        assertTrue(aGetMethod1 == aGetMethod2);
    }

    @Test
    public void testReadOnly() {
        RestMethod getMethod = RestMethod.GET;
        assertTrue(getMethod.isReadOnly());
    }

    @Test
    public void testDefaultMethod() {
        BasicInterface bi = new BasicInterface() {
            @Override
            public Object SomeMethod() {
                return new Object();
            }
        };

        assertEquals("default string", bi.newMethod());
    }
}
