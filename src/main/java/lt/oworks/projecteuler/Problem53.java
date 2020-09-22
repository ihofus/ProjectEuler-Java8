package lt.oworks.projecteuler;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Created by ovidijus on 03/06/2017.
 */
public class Problem53 {

    public static void main(final String... args) {
        final BigInteger limit = BigInteger.valueOf(1000000);
        long count = 0;

        for (int n = 1; n <= 100; n++) {
            BigInteger nn = BigInteger.valueOf(n);
            count += IntStream.rangeClosed(1, n)
                    .mapToObj(BigInteger::valueOf)
                    .map(r -> combinatoricSelections(nn, r))
                    .filter(c -> c.compareTo(limit) > 0)
                    .count();
        }

        System.out.println(count);

    }

    private static BigInteger factorial(final BigInteger number) {
        if (BigInteger.ZERO.compareTo(number) == 0) {
            return BigInteger.ONE;
        }

        BigInteger n = BigInteger.ONE;
        BigInteger fact = BigInteger.ONE;
        while (n.compareTo(number) < 1) {
            fact = fact.multiply(n);
            n = n.add(BigInteger.ONE);
        }
        return fact;
    }

    private static BigInteger combinatoricSelections(final BigInteger n, final BigInteger r) {
        return factorial(n).divide(factorial(r).multiply(factorial(n.subtract(r))));
    }
}
