package motion.blevast.com.executor.connection;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * A Base response implementation test
 */

public class BaseResponseImplTest {

    //
    StringResponse stringResponse;
    HttpURLConnection httpURLConnection;

    //
    @Before public void setUp() throws IOException {

        //
        httpURLConnection = mock(HttpURLConnection.class);

        //
        when(httpURLConnection.getInputStream()).thenReturn(
                BaseResponseImplTest.class.getClassLoader().getResourceAsStream("vast_inline_linear.xml"));
        stringResponse = spy(new StringResponse(200, httpURLConnection));
    }

    //
    @Test public void test_base_response_impl_string() throws IOException {
        verify(stringResponse, times(0)).parseRawResponse(httpURLConnection.getInputStream());
        assertNotNull(stringResponse);
    }

    //
    @Test public void test_base_response_impl_data() throws IOException {
        verify(stringResponse, times(0)).parseRawResponse(httpURLConnection.getInputStream());
        assertNotNull(stringResponse);
    }
}
