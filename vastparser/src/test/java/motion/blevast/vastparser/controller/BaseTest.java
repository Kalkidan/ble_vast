package motion.blevast.vastparser.controller;

import org.junit.Before;

import java.io.IOException;

import motion.blevast.com.executor.UsecaseHandler;

/**
 * Common run for tests
 */

public class BaseTest {

    UsecaseHandler usecaseHandler;

    @Before
    public void setUp() throws IOException{
        //A test run for use case handler and thread pool scheduler
        //usecaseHandler = new UsecaseHandler(new TestThreadPoolScheduler());
    }
}
