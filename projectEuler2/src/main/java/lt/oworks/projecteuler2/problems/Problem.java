package lt.oworks.projecteuler2.problems;

/**
 *
 * @author narkeovi
 */
public abstract class Problem {

    abstract protected String solve();

    public Result doSolve() {
        final long start = System.currentTimeMillis();
        final String result = solve();
        final long end = System.currentTimeMillis();
        return new Result(end - start, result);
    }

    public class Result {

        public final long durationMs;
        public final String result;

        public Result(long durationMs, String result) {
            this.durationMs = durationMs;
            this.result = result;
        }

        @Override
        public String toString() {
            return "Duration: " + durationMs + "ms\nResult: " + result;
        }

    }
}
