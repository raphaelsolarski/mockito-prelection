package com.raphaelsolarski.annotation.init;

import com.raphaelsolarski.postoffice.repository.CourierCompanyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class InitAnnotationsTest {

    @Mock
    CourierCompanyRepository mock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void someTestWithMockito() throws Exception {
        Assert.assertNotNull(mock);
    }

}
