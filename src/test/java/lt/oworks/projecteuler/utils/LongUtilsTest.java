package lt.oworks.projecteuler.utils;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongUtilsTest {
	@Test
	public void replaceDigits() throws Exception {
/*		assertArrayEquals(new long[] { 23, 31 },LongUtils.replaceDigits(21, 3, 1)
						   .sorted()
		.toArray());*/

	}

	@Test
	public void primes() throws Exception {
		assertTrue(LongUtils.primes().limit(100).allMatch(LongUtils::isPrime));

		final long[] primes = LongUtils.primes().limit(5).toArray();
		assertArrayEquals(new long[] { 2, 3, 5, 7, 11 }, primes);
	}

	@Test
	public void isPrime() throws Exception {
		assertTrue(LongUtils.isPrime(2));
		assertTrue(LongUtils.isPrime(3));
		assertTrue(LongUtils.isPrime(5));
		assertTrue(LongUtils.isPrime(19));
		assertTrue(LongUtils.isPrime(37));

		assertFalse(LongUtils.isPrime(0));
		assertFalse(LongUtils.isPrime(1));
		assertFalse(LongUtils.isPrime(4));
		assertFalse(LongUtils.isPrime(44));
	}

}