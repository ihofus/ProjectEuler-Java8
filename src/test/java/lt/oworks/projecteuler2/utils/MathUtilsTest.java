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

    @Test
    public void testGetPermutations() {
        assertNull(MathUtils.getPermutations(-1));

        assertEquals(Arrays.asList(new Long[]{0L}), MathUtils.getPermutations(0));

        assertEquals(Arrays.asList(new Long[]{1L}), MathUtils.getPermutations(1));

        assertEquals(Arrays.asList(new Long[]{1L, 10L}), MathUtils.getPermutations(10));

        assertEquals(Arrays.asList(new Long[]{123L, 132L, 213L, 231L, 312L, 321L}), MathUtils.getPermutations(123));
        assertEquals(Arrays.asList(new Long[]{123L, 132L, 213L, 231L, 312L, 321L}), MathUtils.getPermutations(321));
    }

    @Test
    public void testIsArithmeticSequence() {

        assertFalse(MathUtils.isArithmeticSequence(Arrays.asList(new Long[]{})));
        assertTrue(MathUtils.isArithmeticSequence(Arrays.asList(new Long[]{1L})));
        assertTrue(MathUtils.isArithmeticSequence(Arrays.asList(new Long[]{1L, 2L})));
        assertTrue(MathUtils.isArithmeticSequence(Arrays.asList(new Long[]{1L, 2L, 3L})));
        assertTrue(MathUtils.isArithmeticSequence(Arrays.asList(new Long[]{1L, 6L, 11L, 16L, 21L})));
        assertFalse(MathUtils.isArithmeticSequence(Arrays.asList(new Long[]{5L, 6L, 11L, 16L, 21L})));
    }

}
