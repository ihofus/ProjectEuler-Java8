package lt.oworks.projecteuler.problems.impl;

import lt.oworks.projecteuler.problems.Problem;
import lt.oworks.projecteuler.utils.LongUtils;
import lt.oworks.projecteuler.utils.Utils;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by ovidijus on 03/06/2017.
 */
public class Problem51 extends Problem {
    private Map<Integer, List<String>> templatesMap = new HashMap<>();

    @Override
    protected String solve() {
        return LongStream.iterate(2, i -> i + 1)
                .mapToObj(n -> primes(n, 8))
                .filter(a -> a.length == 8)
                .findFirst()
                .map(Arrays::toString)
                .get();
    }

    private List<String> getTemplates(final long number) {
        final int length = Long.toString(number).length();
        List<String> result = templatesMap.get(length);
        if (result == null) {
            result = new LinkedList<>();
            templatesMap.put(length, result);
            IntStream.range(0, length)
                    .mapToObj(i -> Utils.combinationsMasks(length, i))
                    .forEach(result::addAll);
        }
        return result;
    }

    private long[] primes(final long number, final int length) {
        final List<String> templates = getTemplates(number);
        return templates.stream()
                .map(tpl -> LongUtils.replaceDigits(number, tpl))
                .map(longs -> Arrays.stream(longs).filter(LongUtils::isPrime).toArray())
                .filter(primes -> primes.length == length)
                .findFirst().orElse(new long[]{});
    }
}
