package lt.oworks.projecteuler.problems;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class Problem57 {
    public static void main(String[] args) {
        System.out.println(

                IntStream.range(1, 1000)
                        .mapToObj(Problem57::after)
                        .map(Fraction::simplify)
                        .peek(System.out::println)
                        .filter(f -> f.numerator.toString().length() > f.denominator.toString().length())
                        .count()
        );
    }

    static Fraction after(int iterations) {
        if (iterations == 1) {
            return Fraction.ONE.add(Fraction.HALF);
        }
        Fraction result = Fraction.HALF;
        int i = 1;
        while (i < iterations) {
            result = Fraction.TWO.add(result).inverse();
            i++;
        }

        return Fraction.ONE.add(result);
    }

    static class Fraction {
        static final Fraction ONE = new Fraction(BigDecimal.ONE);
        static final Fraction TWO = new Fraction(BigDecimal.valueOf(2));
        static final Fraction HALF = new Fraction(BigDecimal.ONE, BigDecimal.valueOf(2));
        private final BigDecimal numerator;
        private final BigDecimal denominator;

        Fraction(BigDecimal num) {
            this(num, BigDecimal.ONE);
        }

        Fraction(BigDecimal numerator, BigDecimal denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        Fraction add(Fraction other) {
            if (denominator.equals(other.denominator)) {
                return new Fraction(numerator.add(other.numerator), denominator);
            }

            return new Fraction(numerator.multiply(other.denominator).add(other.numerator.multiply(denominator)), denominator.multiply(other.denominator));
        }

        Fraction inverse() {
            return new Fraction(denominator, numerator);
        }

        Fraction simplify() {
            BigDecimal div = BigDecimal.valueOf(2);

            BigDecimal newN = numerator;
            BigDecimal newD = denominator;

            while (newN.max(newD).compareTo(div) <= 0) {
                if (newN.remainder(div).equals(BigDecimal.ZERO) && newD.remainder(div).equals(BigDecimal.ZERO)) {
                    newD = newD.divide(div);
                    newN = newN.divide(div);
                } else {
                    div = div.add(BigDecimal.ONE);
                }
            }

            return new Fraction(newN, newD);
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }
}
