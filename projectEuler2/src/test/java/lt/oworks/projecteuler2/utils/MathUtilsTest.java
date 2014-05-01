package lt.oworks.projecteuler2.utils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author narkeovi
 */
public class MathUtilsTest {

    public MathUtilsTest() {
    }

    @Test
    public void testIsPrime() {
        assertEquals(false, MathUtils.isPrime(0));

        assertEquals(false, MathUtils.isPrime(1));

        assertEquals(true, MathUtils.isPrime(2));
    }

}
