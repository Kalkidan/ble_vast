package motion.blevast.com.executor.connection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.when;

/**
 * A simple base request test
 */

@RunWith(MockitoJUnitRunner.class)
public class BaseRequestTest {

    @Mock BaseRequestImpl baseRequest;


    @Before public void setUp(){
        when(baseRequest.getBaseUrl()).thenReturn("This is the base url");
        when(baseRequest.getBody()).thenReturn("This is a body");
        when(baseRequest.getConnectionParameter()).thenReturn(new ConnectionParameter());
    }

    @Test
    public void test_base_request_test(){
        assertNotNull(baseRequest);
    }
}
