package lt.oworks.projecteuler2.utils;

import java.util.ArrayList;
import java.util.List;

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
}
