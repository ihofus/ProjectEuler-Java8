package lt.oworks.projecteuler2.problems.impl;

import lt.oworks.projecteuler2.problems.Problem;
import lt.oworks.projecteuler2.utils.MathUtils;

/**
 *
 * @author Ovidijus N.
 */
public class Problem49 extends Problem {

    @Override
    protected String solve() {

        return MathUtils.isPrime(274876858367L) + "";
    }

}
