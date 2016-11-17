package com.raphaelsolarski.mock;

import com.raphaelsolarski.models.SimpleClass;
import com.raphaelsolarski.postoffice.model.Delivery;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;

import java.util.ArrayList;

public class VerifyTest {

    @Test
    public void shouldVerifyThatMethodWasInvoked() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatReturnsInt();

        Mockito.verify(simpleClass).methodThatReturnsInt();
    }

    @Test
    public void shouldVerifyThatMethodWasInvokedTwice() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatReturnsInt();
        simpleClass.methodThatReturnsInt();

        Mockito.verify(simpleClass, Mockito.times(2)).methodThatReturnsInt();
    }

    @Test
    public void shouldVerifyThatMethodWasNotInvoked() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        Mockito.verify(simpleClass, Mockito.never()).methodThatReturnsInt();
    }

    @Test
    public void shouldVerifyThatMethodWasNotInvokedAtLeastOnce() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatReturnsInt();
        simpleClass.methodThatReturnsInt();
        simpleClass.methodThatReturnsInt();

        Mockito.verify(simpleClass, Mockito.atLeastOnce()).methodThatReturnsInt();
    }

    @Test
    public void methodShouldBeInvokedWithGivenArgument() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatGetsString("foo");

        Mockito.verify(simpleClass).methodThatGetsString("foo");
    }

    @Test
    public void methodShouldNotBeInvokedWithGivenArgument() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatGetsString("foo");

        Mockito.verify(simpleClass).methodThatGetsString("foo");
        Mockito.verify(simpleClass, Mockito.never()).methodThatGetsString("bar");
    }

    @Test
    public void methodShouldBeInvokedWithNull() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatGetsString(null);

        Mockito.verify(simpleClass).methodThatGetsString(null);
    }

    @Test
    public void methodShouldBeInvokedWithAnyString() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatGetsString("foo");

        Mockito.verify(simpleClass).methodThatGetsString(Mockito.anyString());
    }

    @Test
    public void methodShouldBeInvokedWithAnyCollection() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatGetsCollection(new ArrayList<>());

        Mockito.verify(simpleClass).methodThatGetsCollection(Mockito.anyCollection());
    }

    @Test
    public void anyCollectionDoesNotDoAnyTypeChecking() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatGetsCollection(new ArrayList<Delivery>());

        Mockito.verify(simpleClass).methodThatGetsCollection(Mockito.anyCollectionOf(Integer.class));
    }

    @Test
    public void methodShouldBeInvokedWithAnyObject() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatGetsObject(new Delivery());

        Mockito.verify(simpleClass).methodThatGetsObject(Mockito.anyObject());
    }

    @Test
    public void anyDoesNotDoAnyTypeChecking() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodThatGetsObject(new Delivery());

        Mockito.verify(simpleClass).methodThatGetsObject(Mockito.any(Integer.class));
    }

    @Test(expected = InvalidUseOfMatchersException.class)
    public void wrongUsageOfMatchers() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodWithTwoParameters("foo", "bar");

        Mockito.verify(simpleClass).methodWithTwoParameters("foo", Mockito.anyString());
    }

    @Test
    public void whenYouUseMatchersThenUseThemEverywhere() throws Exception {
        SimpleClass simpleClass = Mockito.mock(SimpleClass.class);

        simpleClass.methodWithTwoParameters("foo", "bar");

        Mockito.verify(simpleClass).methodWithTwoParameters(Mockito.eq("foo"), Mockito.anyString());
    }

}
