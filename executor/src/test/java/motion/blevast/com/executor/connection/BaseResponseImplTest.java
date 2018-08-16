package motion.blevast.com.executor.connection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.HttpURLConnection;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * A Base response implementation test
 */
@RunWith(MockitoJUnitRunner.class)
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
        //check if the resource stream is null or not.
        assertNotNull(httpURLConnection.getInputStream());

    }

    //
    @Test public void test_base_response_impl_data() throws IOException {
        //Let us parse the data
        StringResponseCreator.ResponseValues responseValues =
                new StringResponseCreator.ResponseValues(200, httpURLConnection.getInputStream());

        assertNotNull(responseValues);

        //parse the response values
        assertNotNull(responseValues.parseRawResponse(httpURLConnection.getInputStream()));


    }
}
