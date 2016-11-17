package com.raphaelsolarski.mock;

import com.raphaelsolarski.models.SimpleClass;
import com.raphaelsolarski.postoffice.model.Address;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

    @Test
    public void spyCreation() throws Exception {
        Address address = Mockito.spy(Address.class);

        address.setBuildingNumber("someString");

        Assert.assertEquals("someString", address.getBuildingNumber());
        Mockito.verify(address).setBuildingNumber(Mockito.anyString());
    }

    @Test
    public void createSpyFromExistingObject() throws Exception {
        Address address = new Address();
        address.setBuildingNumber("someString");

        address = Mockito.spy(address);
        address.setId(1);

        Assert.assertEquals("someString", address.getBuildingNumber());
        Assert.assertEquals(Integer.valueOf(1), address.getId());
        Mockito.verify(address).setId(Mockito.anyInt());
    }

    @Test
    public void stubbingSpyObject() throws Exception {
        SimpleClass simpleClass = Mockito.spy(SimpleClass.class);

        Assert.assertNotNull(simpleClass.methodThatReturnsObject());
        Assert.assertEquals(1, simpleClass.methodThatReturnsInt());

        Mockito.doReturn(2).when(simpleClass).methodThatReturnsInt();

        Assert.assertEquals(2, simpleClass.methodThatReturnsInt());
    }


    @Test
    public void dangerousWayStubbingSpyObject() throws Exception {
        SimpleClass simpleClass = Mockito.spy(SimpleClass.class);

        Assert.assertNotNull(simpleClass.methodThatReturnsObject());
        Assert.assertEquals(1, simpleClass.methodThatReturnsInt());

        Mockito.when(simpleClass.methodThatReturnsInt()).thenReturn(2);

        Assert.assertEquals(2, simpleClass.methodThatReturnsInt());
    }

    @Test(expected = RuntimeException.class)
    public void howToNotStubSpyMethod() throws Exception {
        SimpleClass simpleClass = Mockito.spy(SimpleClass.class);

        Assert.assertNotNull(simpleClass.methodThatReturnsObject());
        Assert.assertEquals(1, simpleClass.methodThatReturnsInt());

        Mockito.when(simpleClass.methodThatSometimesThrowsException(null)).thenReturn(2);
    }

    @Test
    public void howToDoItProperly() throws Exception {
        SimpleClass simpleClass = Mockito.spy(SimpleClass.class);

        Assert.assertNotNull(simpleClass.methodThatReturnsObject());
        Assert.assertEquals(1, simpleClass.methodThatReturnsInt());

        Mockito.doReturn(2).when(simpleClass).methodThatSometimesThrowsException(null);

        Assert.assertEquals(2, simpleClass.methodThatSometimesThrowsException(null));
    }

    @Test(expected = RuntimeException.class)
    public void spyMethodShouldThrowException() throws Exception {
        SimpleClass simpleClass = Mockito.spy(SimpleClass.class);

        Mockito.doThrow(new RuntimeException()).when(simpleClass).methodThatReturnsInt();

        simpleClass.methodThatReturnsInt();
    }

    @Test
    public void spyShouldNotThrowException() throws Exception {
        SimpleClass simpleClass = Mockito.spy(SimpleClass.class);

        Mockito.doNothing().when(simpleClass).voidMethodThatThrowsException();

        simpleClass.voidMethodThatThrowsException();
    }

    @Test(expected = RuntimeException.class)
    public void spyShouldDoNothingAndNextCallRealMethod() throws Exception {
        SimpleClass simpleClass = Mockito.spy(SimpleClass.class);

        Mockito.doNothing()
                .doCallRealMethod()
                .when(simpleClass).voidMethodThatThrowsException();

        simpleClass.voidMethodThatThrowsException();
        simpleClass.voidMethodThatThrowsException();
    }

    @Test(expected = MockitoException.class)
    public void doNotDoItInHome() throws Exception {
        Mockito.spy(Mockito.spy(new Object()));
    }

}
