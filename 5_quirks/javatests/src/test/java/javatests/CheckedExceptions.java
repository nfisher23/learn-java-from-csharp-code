package javatests;

import org.junit.Test;

public class CheckedExceptions {

    // won't compile
//    @Test
//    public void testCheckedException() {
//        throw new CustomCheckedException("some checked exception");
//    }

    @Test
    public void testCheckedException_swallow() {
        try {
            throw new CustomCheckedException("some checked exception");
        } catch (CustomCheckedException e) {
            // handle the problem
        }
    }

    // compiles, but still fails if we run a JUnit Test as it's throwing an exception
    public void testCheckedException_signature() throws CustomCheckedException {
        throw new CustomCheckedException("some checked exception");
    }
}


