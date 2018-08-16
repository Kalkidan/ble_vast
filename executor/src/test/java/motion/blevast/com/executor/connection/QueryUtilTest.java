package motion.blevast.com.executor.connection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest(QueryUtil.class)
@RunWith(PowerMockRunner.class)
public class QueryUtilTest {

    @Before public void setup(){
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(QueryUtil.class);
        PowerMockito.when(QueryUtil.buildRegistrationUri("string", "string", "string")).thenCallRealMethod();
    }

    @Test public void test_uri_validity(){

    }
}
