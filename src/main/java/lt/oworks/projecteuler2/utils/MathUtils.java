package lt.oworks.projecteuler2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Ovidijus N.
 */
public class MathUtils {

    public static boolean isPrime(final long pPrime) {
        if (pPrime == 2) {
            return true;
        } else if (pPrime % 2 == 0) {
            return false;
        } else if (pPrime > 2) {
            final double root = Math.sqrt(pPrime);
            for (long i = 3; i < root + 1; i += 2) {
                if (pPrime % i == 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static List<Integer> toDigits(final long pNumber) {
        if (pNumber < 0) {
            return null;
        } else {
            final List<Integer> digits = new ArrayList<>();
            long temp = pNumber;
            do {
                long lastDigit = temp % 10;
                temp = temp / 10;
                digits.add(0, (int) lastDigit);
            } while (temp > 0);
            return digits;
        }
    }

    public static List<Long> getPermutations(final long pNumber) {
        if (pNumber < 0) {
            return null;
        } else {
            final Set<Long> permutions = new TreeSet<>();
            final List<Integer> digits = toDigits(pNumber);
            findPermutions(permutions, digits, 0);
            return new ArrayList<>(permutions);
        }
    }

    private static void findPermutions(final Set<Long> pPermutions, final List<Integer> pDigits, final long pPermution) {
        if (pDigits.isEmpty()) {
            pPermutions.add(pPermution);
            return;
        }
        pDigits.stream().forEach((digit) -> {
            final List<Integer> digits = new ArrayList<>(pDigits);
            digits.remove(digit);
            findPermutions(pPermutions, digits, pPermution * 10 + digit);
        });
    }

    public static boolean isArithmeticSequence(final List<Long> pNumbers) {
        switch (pNumbers.size()) {
            case 0:
                return false;
            case 1:
            case 2:
                return true;
            default:
                final long diff = pNumbers.get(1) - pNumbers.get(0);
                for (int i = 0; i < pNumbers.size() - 1; i++) {
                    if (diff != pNumbers.get(i + 1) - pNumbers.get(i)) {
                        return false;
                    }
                }
                return true;
        }
    }
}
