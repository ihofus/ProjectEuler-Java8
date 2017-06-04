package lt.oworks.projecteuler2.utils;


import java.util.LinkedList;
import java.util.List;

public final class Utils {

    public static List<String> combinationsMasks(final int length, final int count) {
        final List<String> result = new LinkedList<>();
        combinationsMasks(new StringBuilder(), length, count, result);
        return result;
    }

    private static void combinationsMasks(final StringBuilder maskBuilder, int length, int count, List<String> result) {
        if (length == 0) {
            result.add(maskBuilder.toString());
        } else {
            if (count > 0) {
                final StringBuilder clone1 = new StringBuilder(maskBuilder);
                clone1.append('x');
                combinationsMasks(clone1, length - 1, count - 1, result);
            }
            if (count < length) {
                final StringBuilder clone2 = new StringBuilder(maskBuilder);
                clone2.append('_');
                combinationsMasks(clone2, length - 1, count, result);
            }
        }
    }

    private Utils() {
    }
}
