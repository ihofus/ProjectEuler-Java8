package lt.oworks.projecteuler.problems;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem56 {
    public static void main(String[] args) {


        System.out.println(IntStream.range(1, 100)
                .mapToObj(BigDecimal::valueOf)
                .flatMap(a -> IntStream.range(1, 100)
                        .mapToObj(a::pow))
                .map(Object::toString)
                .map(ab -> ab.split(""))
                .mapToInt(ab -> Arrays.stream(ab).mapToInt(Integer::parseInt)
                        .reduce(0, Integer::sum))
                .max());
    }


}
