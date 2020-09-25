package lt.oworks.projecteuler.problems;

import lt.oworks.projecteuler.utils.LongUtils;

public class Problem58 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int length = 3;
        while (true) {
            newLayer(counter, length);
            if ((counter.primes / counter.total) < 0.1) {
                break;
            }
            length += 2;
        }
        System.out.println(length);
    }

    static long diagonal(int length, int corner) {
        return length * length - corner * (length - 1);
    }

    static void newLayer(Counter counter, int length) {
        for (int i = 0; i < 4; i++) {
            counter.total++;
            long number = diagonal(length, i);
            if (LongUtils.isPrime(number)) {
                counter.primes++;
            }
        }
    }

    static class Counter {
        double total = 1;
        int primes = 0;
    }
}
