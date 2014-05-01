package lt.oworks.projecteuler2.config;

import lt.oworks.projecteuler2.config.ProblemRunner;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import lt.oworks.projecteuler2.problems.Problem;
import lt.oworks.projecteuler2.problems.impl.Problem49;

/**
 *
 * @author Ovidijus N.
 */
public class ProblemsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Runnable.class).to(ProblemRunner.class);

        bind(Problem.class).annotatedWith(Names.named("Problem49")).to(Problem49.class);
    }

}
