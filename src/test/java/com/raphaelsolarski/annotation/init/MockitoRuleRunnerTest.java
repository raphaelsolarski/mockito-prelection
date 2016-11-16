package com.raphaelsolarski.annotation.init;

import com.raphaelsolarski.postoffice.repository.CourierCompanyRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRule;
import org.mockito.junit.MockitoRule;

public class MockitoRuleRunnerTest {

    @Rule
    public MockitoRule mockitoRule = new MockitoJUnitRule();

    @Mock
    CourierCompanyRepository mock;

    @Test
    public void someTestWithMockito() throws Exception {
        Assert.assertNotNull(mock);
    }

}
