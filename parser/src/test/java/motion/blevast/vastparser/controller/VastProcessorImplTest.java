package motion.blevast.vastparser.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import motion.blevast.com.executor.connection.ConnectionParameter;
import motion.blevast.parser.controller.VastProcessorImpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Vast Process Implementation test
 */
@RunWith(MockitoJUnitRunner.class)
public class VastProcessorImplTest {

    @InjectMocks //this creates the real instance
    VastProcessorImpl vastProcessorImpl;

    @Before public void setUp() throws IOException{
    }

    @Test public void vast_processor_impl_test(){
        //
        assertNotNull(vastProcessorImpl);

        //Execute the networking UseCase
    }
}
