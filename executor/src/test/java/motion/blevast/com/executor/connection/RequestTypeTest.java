package motion.blevast.com.executor.connection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(PowerMockRunner.class)
@PrepareForTest(RequestType.class)

public class RequestTypeTest {

    @Before public void setup(){
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(RequestType.class);
        PowerMockito.when(RequestType.values()).
                thenReturn(new RequestType[]{RequestType.DELETE,
                        RequestType.GET,
                        RequestType.POST,
                        RequestType.PUT});
    }

    @Test public void check_if_request_type_is_not_null(){



    }
}
