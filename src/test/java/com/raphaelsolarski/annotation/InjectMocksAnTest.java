package com.raphaelsolarski.annotation;

import com.raphaelsolarski.postoffice.model.Delivery;
import com.raphaelsolarski.postoffice.repository.DeliveryRepository;
import com.raphaelsolarski.postoffice.service.DeliveryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InjectMocksAnTest {

    @Mock
    private DeliveryRepository deliveryRepository;

    @InjectMocks
    private DeliveryService deliveryService = new DeliveryService();

    @Test
    public void shouldUseInjectedMock() throws Exception {
        Mockito.doReturn(new Delivery()).when(deliveryRepository).findOne(Mockito.eq(1));

        deliveryService.deleteDeliveryById(1);

        Mockito.verify(deliveryRepository).findOne(Mockito.eq(1));
    }

}
