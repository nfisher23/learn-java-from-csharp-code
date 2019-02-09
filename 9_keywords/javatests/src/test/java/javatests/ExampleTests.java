package javatests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ExampleTests {

    // java 10+ only
    @Test
    public void varKeyword_java10() {
        var someArrayList = new ArrayList();

        assertEquals(someArrayList.getClass(), ArrayList.class);
    }

    @Test
    public void testForeach() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        for (Integer number : numbers) {
            assertTrue(number > 0);
        }
    }

    @Test
    public void testStaticAccessOfInstance() {
        SomeClass s = new SomeClass();
        String thisWorks = s.staticField;
        assertEquals("static", thisWorks);

        String methodReturn = s.staticMethod();
        assertEquals("static method", methodReturn);
    }

    private List<String> transformToStringList(int... ints) {
        List<String> listOfVarargs = new ArrayList<>();

        for (int i : ints) {
            listOfVarargs.add(Integer.toString(i));
        }

        return listOfVarargs;
    }

    @Test
    public void varargsTest() {
        List<String> vals = transformToStringList(1,2,3);
        assertEquals("1", vals.get(0));
    }

    @Test
    public void testPackagePrivate() {
        DefaultAccess access = new DefaultAccess();
        int val = access.defaultsToPackagePrivate;
        assertEquals(10, val);
    }

    @Test
    public void testInstanceOfKeyword() {
        Object pair = new Placeholder();
        assertTrue(pair instanceof Placeholder);
    }
}
