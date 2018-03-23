package motion.blevast.com.executor.connection;

import org.junit.Before;
import org.junit.Test;


import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.spy;

/**
 * A Connection parameter test
 */

public class ConnectionParameterTest {

    ConnectionParameter connectionParameter;

    //
    @Before public void setUp(){
        connectionParameter = spy(new ConnectionParameter(RequestType.POST));
    }

    //
    @Test public void test_connection_parameter(){
        assertNotNull(connectionParameter);
    }
}
