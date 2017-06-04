package lt.oworks.projecteuler2.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public final class LongUtils {

    public static int[] toDigits(final long number) {
        return Arrays.stream(Long.toString(number).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static long[] replaceDigits(final long number, final String template) {
        final String asString = Long.toString(number);
        final List<String> result = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            final StringBuilder builder = new StringBuilder();
            for (int j = 0; j < asString.length(); j++) {
                if (template.charAt(j) == 'x') {
                    builder.append(i);
                } else {
                    builder.append(asString.charAt(j));
                }
            }
            result.add(builder.toString());
        }

        return result.stream()
                .filter(s -> !s.startsWith("0"))
                .mapToLong(Long::parseLong).toArray();
    }

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
