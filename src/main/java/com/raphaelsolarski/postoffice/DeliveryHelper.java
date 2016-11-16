package com.raphaelsolarski.postoffice;

import com.raphaelsolarski.postoffice.model.Address;
import com.raphaelsolarski.postoffice.model.Delivery;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DeliveryHelper {

    public List<Delivery> findDeliveryWithGivenTargetAddressAndSendDateBetween(Collection<Delivery> deliveries,
                                                                               Address address,
                                                                               Date startDate, Date endDate) {
        return deliveries.stream()
                .filter(delivery -> Objects.equals(delivery.getTargetAddress(), address))
                .filter(delivery -> delivery.getSendDate().after(startDate) && delivery.getSendDate().before(endDate))
                .collect(Collectors.toList());
    }

}
