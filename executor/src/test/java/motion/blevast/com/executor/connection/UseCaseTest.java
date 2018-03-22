package motion.blevast.com.executor.connection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.HttpURLConnection;

import motion.blevast.com.executor.UsecaseCallback;
import motion.blevast.com.executor.connection.NetworkContractImpl;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * A use case test that runs
 */

@RunWith(MockitoJUnitRunner.class)
public class UseCaseTest {

    @Mock NetworkContractImpl networkContract;
    @Mock NetworkContractImpl.ResponseValues responseValues;
    @Mock NetworkContractImpl.RequestValues requestValues;
    @Mock UsecaseCallback usecaseCallback;

    @Before
    public void setUp() {
        requestValues.setConnectionParameter(new ConnectionParameter(RequestType.GET));
        requestValues.setBaseUrl("give it a base url");
        requestValues.setDestinationUrl("give it a destination url hrere");
    }

    @Test
    public void test_use_case() throws IOException {

        //Check if the network contract is null or not.
        assertNotNull(networkContract);
        //Execute the usecase
        networkContract.executeUsecase(requestValues, usecaseCallback);
        //Mock the Httpurl connection
        HttpURLConnection httpURLConnection = mock(HttpURLConnection.class);
        //Mock the response out
        when(httpURLConnection.getResponseCode()).thenReturn(200);


    }
}
