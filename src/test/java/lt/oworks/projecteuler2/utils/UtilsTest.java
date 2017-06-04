package lt.oworks.projecteuler2.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class UtilsTest {
    @Test
    public void combinationsMasks() {
        List<String> rez = Utils.combinationsMasks(1, 1);
        assertEquals(1, rez.size());
        assertTrue(rez.contains("x"));

        rez = Utils.combinationsMasks(3, 1);
        assertEquals(3, rez.size());
        assertTrue(rez.contains("x__"));
        assertTrue(rez.contains("_x_"));
        assertTrue(rez.contains("__x"));

        rez = Utils.combinationsMasks(3, 2);
        assertEquals(3, rez.size());
        assertTrue(rez.containsAll(Arrays.asList("xx_", "x_x", "_xx")));

        rez = Utils.combinationsMasks(4, 3);
        assertEquals(4, rez.size());
        assertTrue(rez.containsAll(Arrays.asList("xxx_", "xx_x", "x_xx", "_xxx")));

        rez = Utils.combinationsMasks(4, 4);
        assertEquals(1, rez.size());
        assertTrue(rez.containsAll(Arrays.asList("xxxx")));
    }
}