package motion.blevast.com.executor.connection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * A Simple BaseError Test
 */
@RunWith(MockitoJUnitRunner.class)
public class BaseErrorTest {

    //Mocking the BaseError
    @Mock BaseError baseError;

    //
    @Before public void setUp(){
        when(baseError.getErrorMessage()).thenReturn("A Generic Error");
        when(baseError.getResponseCode()).thenReturn(200);
    }

    //
    @Test public void test_base_error(){
        assertNotNull(baseError);
    }


}
