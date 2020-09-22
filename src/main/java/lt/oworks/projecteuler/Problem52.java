package lt.oworks.projecteuler;

import lt.oworks.projecteuler.utils.LongUtils;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * Created by ovidijus on 03/06/2017.
 */
public class Problem52 {

    public static void main(String... args) {
        LongStream.iterate(1, i -> i + 1)
                .filter(Problem52::permutedMultiples)
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static boolean permutedMultiples(final long number) {
        final int[] digits = LongUtils.toDigits(number);
        Arrays.sort(digits);

        final int[] digits2 = LongUtils.toDigits(number * 2);
        Arrays.sort(digits2);
        if (!Arrays.equals(digits, digits2)) {
            return false;
        }

        final int[] digits3 = LongUtils.toDigits(number * 3);
        Arrays.sort(digits3);
        if (!Arrays.equals(digits, digits3)) {
            return false;
        }

        final int[] digits4 = LongUtils.toDigits(number * 4);
        Arrays.sort(digits4);
        if (!Arrays.equals(digits, digits4)) {
            return false;
        }

        final int[] digits5 = LongUtils.toDigits(number * 5);
        Arrays.sort(digits5);
        if (!Arrays.equals(digits, digits5)) {
            return false;
        }

        final int[] digits6 = LongUtils.toDigits(number * 6);
        Arrays.sort(digits6);
        if (!Arrays.equals(digits, digits6)) {
            return false;
        }

        return true;
    }
}
