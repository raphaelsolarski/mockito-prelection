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
        String province = delivery.getTargetAddress().getProvince();
        return Optional.ofNullable(deliveryRepository.save(delivery));
    }

    public Optional<Delivery> findDeliveryById(Integer deliveryId) {
        return Optional.ofNullable(deliveryRepository.findOne(deliveryId));
    }

    public void deleteDeliveryById(Integer deliveryId) {
        findDeliveryById(deliveryId).ifPresent(delivery -> deliveryRepository.delete(delivery));
    }

}
