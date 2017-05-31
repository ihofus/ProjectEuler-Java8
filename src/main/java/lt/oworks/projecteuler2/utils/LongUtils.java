package lt.oworks.projecteuler2.utils;

import java.util.stream.LongStream;

public final class LongUtils {

	public static LongStream primes() {
		return LongStream.iterate(2, n -> n + 1).filter(LongUtils::isPrime);
	}

	public static boolean isPrime(final long number) {
		if (number == 0 || number == 1) {
			return false;
		}
		long limit = new Double(Math.sqrt(number)).longValue();

		return LongStream.rangeClosed(2, limit)
				.noneMatch(n -> number % n == 0);
	}

	private LongUtils() {
	}
}
