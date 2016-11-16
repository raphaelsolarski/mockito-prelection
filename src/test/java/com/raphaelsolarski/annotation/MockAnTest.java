package com.raphaelsolarski.annotation;

import com.raphaelsolarski.postoffice.model.Delivery;
import com.raphaelsolarski.postoffice.repository.DeliveryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockAnTest {

    @Mock
    private DeliveryRepository deliveryRepository;

    @Test
    public void shouldBeNormalMock() throws Exception {
        Assert.assertNotNull(deliveryRepository);
        Assert.assertNull(deliveryRepository.save(new Delivery()));

        Mockito.verify(deliveryRepository, Mockito.times(1)).save(Mockito.any(Delivery.class));
    }

}
