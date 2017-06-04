package lt.oworks.projecteuler2;

import lt.oworks.projecteuler2.config.ProblemsModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import lt.oworks.projecteuler2.problems.impl.Problem51;
import lt.oworks.projecteuler2.utils.LongUtils;
import lt.oworks.projecteuler2.utils.Utils;

/**
 *
 * @author Ovidijus N.
 */
public class Main {

    private static final Injector injector = Guice.createInjector(new ProblemsModule());

    public static void main(String[] args) {
       System.out.print(new Problem51().doSolve());
    }
}
