package com.raphaelsolarski.annotation;

import com.raphaelsolarski.postoffice.model.Delivery;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class SpyAnTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Spy
    private Delivery delivery;

    @Test
    public void deliveryShouldBeASpy() throws Exception {
        boolean spy = Mockito.mockingDetails(delivery).isSpy();
        Assert.assertTrue(spy);
    }

}
