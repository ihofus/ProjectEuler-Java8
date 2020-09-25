package lt.oworks.projecteuler.problems;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class Problem55 {
    private static final int LIMIT = 50;

    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 10000)
                .filter(Problem55::isLychrelNumber)
                .count());
    }

    private static boolean isLychrelNumber(final int num) {
        BigDecimal dec = BigDecimal.valueOf(num);
        BigDecimal reversed = new BigDecimal(new StringBuilder(dec.toString()).reverse().toString());
        int iter = 1;
        while (iter < LIMIT) {
            iter++;

            dec = dec.add(reversed);
            reversed = new BigDecimal(new StringBuilder(dec.toString()).reverse().toString());

            if (dec.equals(reversed)) {
                return false;
            }
        }
        return true;
    }
}
