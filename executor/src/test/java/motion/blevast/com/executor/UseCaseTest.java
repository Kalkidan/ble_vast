package motion.blevast.com.executor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import motion.blevast.com.executor.connection.NetworkContractImpl;

import static junit.framework.TestCase.assertNotNull;

/**
 * A use case test that runs
 */

@RunWith(MockitoJUnitRunner.class)
public class UseCaseTest {

    @Mock NetworkContractImpl networkContract;
    @Mock NetworkContractImpl.ResponseValues responseValues;
    @Mock NetworkContractImpl.RequestValues requestValues;

    @Before
    public void setUp() {
        //requestValues.
    }

    @Test
    public void test_use_case(){
        assertNotNull(networkContract);
        //networkContract.executeUsecase(requestValues, );
    }
}
