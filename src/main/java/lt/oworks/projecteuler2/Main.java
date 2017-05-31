package lt.oworks.projecteuler2;

import lt.oworks.projecteuler2.config.ProblemsModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 * @author Ovidijus N.
 */
public class Main {

    private static final Injector injector = Guice.createInjector(new ProblemsModule());

    public static void main(String[] args) {
        injector.getInstance(Runnable.class).run();
    }
}
