package motion.blevast.vastparser;

import motion.blevast.com.executor.UsecaseHandler;
import motion.blevast.com.executor.TestThreadPoolScheduler;

/**
 * Common run for tests
 */

public class BaseTest {

    UsecaseHandler usecaseHandler;

    public void setUp(){
        //A test run for use case handler and thread pool scheduler
        usecaseHandler = new UsecaseHandler(new TestThreadPoolScheduler());
    }
}
