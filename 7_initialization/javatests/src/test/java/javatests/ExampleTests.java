package javatests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTests {

    @Test
    public void testDoubleBrace() {
        SimplePair pair = new SimplePair() {{
            setKey(1);
            setValue("first");
        }};

        assertEquals("first", pair.getValue());
    }

    @Test
    public void testBuilder() {
        SimplePairWithBuilder pair = SimplePairWithBuilder.builder()
                .key(1)
                .value("first")
                .build();

        assertEquals("first", pair.getValue());
    }

    @Test
    public void testConstructorCalls() {
        OtherConstructors constructors = new OtherConstructors();
        assertEquals("default value", constructors.getSomeString());
    }
}
