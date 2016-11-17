package com.raphaelsolarski.postoffice;

import com.raphaelsolarski.postoffice.model.Address;
import com.raphaelsolarski.postoffice.model.Delivery;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DeliveryHelper {

    public List<Delivery> findDeliveryWithGivenTargetAddress(Collection<Delivery> deliveries,
                                                             Address address) {
        return deliveries.stream()
                .filter(delivery -> Objects.equals(delivery.getTargetAddress(), address))
                .collect(Collectors.toList());
    }

}
