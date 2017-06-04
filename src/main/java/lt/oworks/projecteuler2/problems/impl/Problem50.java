package lt.oworks.projecteuler2.problems.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import lt.oworks.projecteuler2.problems.Problem;
import lt.oworks.projecteuler2.utils.MathUtils;

/**
 * Consecutive prime sum
 *
 * @author Ovidijus N.
 */
public class Problem50 extends Problem {

    @Override
    protected String solve() {
        final List<Long> primes = new ArrayList<>();
        final List<Long> primes1000 = new ArrayList<>();
        final TreeMap<Integer, Long> primeMap = new TreeMap<>();

        primes.add(2L);

        for (long i = 3; i < 1_000_000; i += 2) {
            if (MathUtils.isPrime(i)) {
                primes.add(i);
                if (i > 1000) {
                    primes1000.add(i);
                }
            }
        }

        final int primesCount = primes.size();
        for (final long p : primes1000) {

            int start = 0;

            while (primes.get(start) < p) {
                long sum = 0;
                int len = 0;
                for (int i = start; i < primesCount; i++) {
                    len++;
                    sum += primes.get(i);
                    if (sum == p) {
                        primeMap.put(len, p);
                        break;
                    } else if (sum > p) {
                        break;
                    }
                }
                start++;
            }
        }

        return primeMap.lastEntry().getValue().toString();
    }

}
