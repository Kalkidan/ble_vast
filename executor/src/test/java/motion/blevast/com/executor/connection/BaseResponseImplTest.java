package motion.blevast.com.executor.connection;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * A Base response implementation test
 */

public class BaseResponseImplTest {

    HttpURLConnection httpURLConnection;

    //
    @Before public void setUp() throws IOException {

        //
        httpURLConnection = mock(HttpURLConnection.class);

        //
        when(httpURLConnection.getInputStream()).thenReturn(
                BaseResponseImplTest.class.getClassLoader().getResourceAsStream("vast_inline_linear.xml"));
    }

    //
    @Test public void test_base_response_impl_string() throws IOException {
    }

    //
    @Test public void test_base_response_impl_data() throws IOException {
    }
}
