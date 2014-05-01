package lt.oworks.projecteuler2.utils;

import java.util.Arrays;
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

    @Test
    public void testToDigits() {
        assertNull(MathUtils.toDigits(-1));

        assertEquals(Arrays.asList(new Integer[]{0}), MathUtils.toDigits(0));

        assertEquals(Arrays.asList(new Integer[]{1}), MathUtils.toDigits(1));

        assertEquals(Arrays.asList(new Integer[]{1, 0}), MathUtils.toDigits(10));

        assertEquals(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}), MathUtils.toDigits(12345));

    }

}
