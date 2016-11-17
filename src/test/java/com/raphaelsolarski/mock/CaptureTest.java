package com.raphaelsolarski.mock;

import com.raphaelsolarski.models.SimpleClass;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class CaptureTest {

    @Test
    public void shouldCaptureValue() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatSometimesThrowsException(5);

        ArgumentCaptor<Integer> intCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(simpleClass).methodThatSometimesThrowsException(intCaptor.capture());
        Assert.assertEquals(Integer.valueOf(5), intCaptor.getValue());
    }

}
