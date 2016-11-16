package com.raphaelsolarski.annotation.init;

import com.raphaelsolarski.postoffice.repository.CourierCompanyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationRunnerTest {

    @Mock
    CourierCompanyRepository mock;

    @Test
    public void someTestWithMockito() throws Exception {
        Assert.assertNotNull(mock);
    }

}
