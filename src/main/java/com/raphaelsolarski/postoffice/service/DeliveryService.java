package com.raphaelsolarski.postoffice.service;

import com.raphaelsolarski.postoffice.model.Delivery;
import com.raphaelsolarski.postoffice.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Optional<Delivery> addOrUpdateDelivery(Delivery delivery) {
        return null;
    }

    public Optional<Delivery> findDeliveryById(Integer deliveryId) {
        return null;
    }

    public boolean deleteDeliveryById(Integer deliveryId) {
        return false;
    }

}
