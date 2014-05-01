package lt.oworks.projecteuler2.utils;

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
}
