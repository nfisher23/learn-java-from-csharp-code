package javatests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ExampleTests {

    public String applyThenToString(int param, IntToInt transformer) {
        return Integer.toString(transformer.integerTransform(param));
    }

    @Test
    public void squareWithLambdas() {
        String doubledAsString = applyThenToString(4, x -> x * x);

        assertEquals("16", doubledAsString);
    }

    @Test
    public void anonymousInnerClass() {
        String doubledAsString = applyThenToString(4, new IntToInt() {
            @Override
            public int integerTransform(int valToTransform) {
                return valToTransform * valToTransform;
            }
        });

        assertEquals("16", doubledAsString);
    }

    @Test
    public void originalListUnchanged() {
        List<Integer> countToFour = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        List<Integer> newCollection = countToFour
                .stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        assertEquals(4, newCollection.get(1).intValue());
        assertNotEquals(newCollection.get(1).intValue(), countToFour.get(1).intValue());
    }

    @Test
    public void deferredExecution() {
        List<Integer> countToFour = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        Stream<Integer> streamOfCount = countToFour.stream().map(n -> n * n);

        countToFour.add(5); // change base collection after stream declaration

        assertEquals(5, streamOfCount.count());
    }

    @Test
    public void conversionOperators() {
        List<Integer> countToFour = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        Stream<Integer> streamOfCount = countToFour.stream().map(n -> n * n);

        List<Integer> first = streamOfCount.collect(Collectors.toList());
        try {
            List<Integer> second = streamOfCount.collect(Collectors.toList()); // IllegalStateException
            fail(); // never get here, runtime exception thrown
        } catch (IllegalStateException e) { }
    }

    @Test
    public void testOptionals() {
        Optional<Object> nullOptional = Optional.ofNullable(null);

        String toStringIfNotNull = nullOptional.map(Object::toString).orElse(null);

        assertNull(toStringIfNotNull);
    }
}
