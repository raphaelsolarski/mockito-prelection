package com.raphaelsolarski.mock;

import com.raphaelsolarski.models.SimpleClass;
import com.raphaelsolarski.models.SimpleInterface;
import com.raphaelsolarski.postoffice.service.DeliveryService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MockTest {

    @Test
    public void mockOfClassCreation() throws Exception {
        Mockito.mock(DeliveryService.class);
    }

    @Test
    public void mockMethodsReturnsDefaultValues() throws Exception {
        SimpleClass mock = Mockito.mock(SimpleClass.class);

        Assert.assertNull(mock.methodThatReturnsObject());
        Assert.assertEquals(0, mock.methodThatReturnsInt());
    }

    @Test
    public void setReturnValues() throws Exception {
        SimpleClass mock = Mockito.mock(SimpleClass.class);

        Mockito.when(mock.methodThatReturnsInt()).thenReturn(1234);

        Assert.assertEquals(1234, mock.methodThatReturnsInt());
    }

    @Test
    public void setReturnValuesInDifferentWay() throws Exception {
        SimpleClass mock = Mockito.mock(SimpleClass.class);

        Mockito.doReturn(1234).when(mock).methodThatReturnsInt();

        Assert.assertEquals(1234, mock.methodThatReturnsInt());
    }

    @Test(expected = RuntimeException.class)
    public void setThrownException() throws Exception {
        SimpleClass mock = Mockito.mock(SimpleClass.class);

        Mockito.when(mock.methodThatReturnsInt()).thenThrow(new RuntimeException());

        mock.methodThatReturnsInt();
    }

    @Test
    public void mockedInterface() throws Exception {
        SimpleInterface simpleInterface = Mockito.mock(SimpleInterface.class);

        Mockito.when(simpleInterface.someMethod(Mockito.anyString())).thenReturn(5);

        Assert.assertEquals(5, simpleInterface.someMethod("foo"));
    }

}
