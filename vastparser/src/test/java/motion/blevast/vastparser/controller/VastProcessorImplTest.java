package motion.blevast.vastparser.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import motion.blevast.com.executor.connection.NetworkContractImpl;
import motion.blevast.vastparser.BaseTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Vast Process Implementation test
 */
@RunWith(MockitoJUnitRunner.class)
public class VastProcessorImplTest extends BaseTest{

    @Mock VastProcessorImpl vastProcessor;
    @Mock NetworkContractImpl.ResponseValues responseValues;


    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void test_get_vast(){
        vastProcessor.getVast();

    }
}
