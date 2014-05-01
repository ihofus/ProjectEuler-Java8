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
        assertEquals("0", false, MathUtils.isPrime(0));

        assertEquals("1", false, MathUtils.isPrime(1));

        assertEquals("2", true, MathUtils.isPrime(2));

        assertEquals("3", true, MathUtils.isPrime(3));

        assertEquals("4", false, MathUtils.isPrime(4));
    }

}
