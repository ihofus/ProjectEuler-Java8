package lt.oworks.projecteuler2.problems.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lt.oworks.projecteuler2.problems.Problem;
import lt.oworks.projecteuler2.utils.MathUtils;

/**
 * Prime permutations
 *
 * @author Ovidijus N.
 */
public class Problem49 extends Problem {

    private final Set<Long> checked = new HashSet<>();
    private final List<List<Long>> results = new ArrayList<>();

    @Override
    protected String solve() {
        for (long i = 1001; i <= 9997; i += 2) {
            if (MathUtils.isPrime(i) && !checked.contains(i)) {
                checked.add(i);
                final List<List<Long>> lists = getPossiblePrimesList(i);
                lists.stream().filter((list) -> (MathUtils.isArithmeticSequence(list))).forEach((list) -> {
                    results.add(list);
                    checked.addAll(list);
                });
            }
        }
        final StringBuilder builder = new StringBuilder();
        for (final List<Long> list : results) {
            for (final long prime : list) {
                builder.append(prime);
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    private List<List<Long>> getPossiblePrimesList(final long pPrime) {
        final List<List<Long>> lists = new ArrayList<>();
        final List<Long> primes = new ArrayList<>();
        MathUtils.getPermutations(pPrime).stream().filter(n -> n > 999).filter(n -> n > 999).filter(n -> !checked.contains(n)).filter(MathUtils::isPrime).forEach(primes::add);

        for (final long prime : primes) {
            final List<Long> seq = new ArrayList<>();
            final List<Long> temp = new ArrayList<>(primes);
            temp.remove(prime);
            seq.add(prime);
            getPossiblePrimesList(lists, temp, seq);
        }

        return lists;
    }

    private void getPossiblePrimesList(final List<List<Long>> pResult, final List<Long> pPrimes, final List<Long> pSeq) {
        if (pSeq.size() == 3) {
            pResult.add(pSeq);
        } else {
            for (final long prime : pPrimes) {
                final List<Long> primes = new ArrayList<>(pPrimes);
                primes.remove(prime);
                if (pSeq.get(pSeq.size() - 1) < prime) {
                    pSeq.add(prime);
                }
                getPossiblePrimesList(pResult, primes, pSeq);
            }
        }
    }
}
