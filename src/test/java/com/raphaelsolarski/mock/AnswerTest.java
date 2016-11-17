package com.raphaelsolarski.mock;

import com.raphaelsolarski.models.SimpleClass;
import com.raphaelsolarski.postoffice.DeliveryHelper;
import com.raphaelsolarski.postoffice.model.Address;
import com.raphaelsolarski.postoffice.model.Delivery;
import org.hibernate.validator.internal.constraintvalidators.bv.AssertFalseValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AnswerTest {

    @Test
    public void spyShouldReturnFixedValue() throws Exception {
        SimpleClass spy = Mockito.spy(SimpleClass.class);

        Answer<Integer> answer = new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return 5;
            }
        };

        Mockito.doAnswer(answer).when(spy).methodThatReturnsInt();

        Assert.assertEquals(5, spy.methodThatReturnsInt());
    }

    @Test
    public void youCanUseLambda() throws Exception {
        SimpleClass spy = Mockito.spy(SimpleClass.class);

        Mockito.doAnswer(invocation -> 5)
                .when(spy)
                .methodThatReturnsInt();

        Assert.assertEquals(5, spy.methodThatReturnsInt());
    }

    @Test
    public void youCanUseInformationAboutInvocation() throws Exception {
        SimpleClass spy = Mockito.spy(SimpleClass.class);

        Mockito.doAnswer(invocation -> invocation.getArgumentAt(0, Integer.class))
                .when(spy)
                .methodThatSometimesThrowsException(Mockito.anyInt());

        Assert.assertEquals(15, spy.methodThatSometimesThrowsException(15));
        Assert.assertEquals(13, spy.methodThatSometimesThrowsException(13));
    }

    @Test
    public void canCallRealMethodInAnswer() throws Exception {
        DeliveryHelper spy = Mockito.spy(DeliveryHelper.class);

        Mockito.doAnswer(invocation -> {
            List<Delivery> list = (List<Delivery>) invocation.callRealMethod();
            list.stream()
                    .filter(delivery -> Objects.equals(delivery.getId(), 1))
                    .forEach(delivery -> delivery.setWeight(5));
            return list;
        })
                .when(spy)
                .findDeliveryWithGivenTargetAddress(
                        Mockito.anyCollectionOf(Delivery.class),
                        Mockito.any(Address.class)
                );

        Address address = new Address();
        Delivery delivery = new Delivery(1);
        delivery.setTargetAddress(address);

        List<Delivery> result = spy.findDeliveryWithGivenTargetAddress(Arrays.asList(delivery, new Delivery(2)), address);

        Optional<Delivery> first = result.stream()
                .filter(delivery1 -> Objects.equals(1, delivery1.getId()))
                .findFirst();

        Assert.assertTrue(first.isPresent());
        Delivery delivery1 = first.get();
        Assert.assertEquals(Integer.valueOf(5), delivery1.getWeight());
    }

}
