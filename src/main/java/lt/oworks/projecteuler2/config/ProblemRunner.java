package lt.oworks.projecteuler2.config;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import lt.oworks.projecteuler2.problems.Problem;

/**
 *
 * @author Ovidijus N.
 */
public class ProblemRunner implements Runnable {

    @Inject
    @Named("Problem50")
    private Problem problem;

    @Override
    public void run() {
        final Problem.Result result = problem.doSolve();

        System.out.println(result);
    }

}
