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

    @InjectMocks
    VastProcessorImpl vastProcessorImpl;

    @Before public void setUp() throws IOException{
    }

    @Test public void vast_processor_impl_test(){
        //
        assertNotNull(vastProcessorImpl);
        assertTrue("The value is ", vastProcessorImpl.getVast(
                "https://http://demo.tremorvideo.com/proddev/vast/vast_inline_nonlinear.xml.google.com",
                new ConnectionParameter()));

        //Execute the networking UseCase
    }
}
