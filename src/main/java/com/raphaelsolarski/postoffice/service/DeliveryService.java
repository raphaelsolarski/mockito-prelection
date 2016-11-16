package com.raphaelsolarski.postoffice.service;

import com.raphaelsolarski.postoffice.model.CourierCompany;
import com.raphaelsolarski.postoffice.model.Delivery;
import com.raphaelsolarski.postoffice.repository.CourierCompanyRepository;
import com.raphaelsolarski.postoffice.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private CourierCompanyRepository courierCompanyRepository;

    public Optional<Delivery> addOrUpdateDelivery(Delivery delivery) {
        String province = delivery.getTargetAddress().getProvince();
        Optional<CourierCompany> byProvince = courierCompanyRepository.findByProvince(province);
        delivery.setCourierCompany(byProvince.orElseThrow(RuntimeException::new));
        return Optional.ofNullable(deliveryRepository.save(delivery));
    }

    public Optional<Delivery> findDeliveryById(Integer deliveryId) {
        return Optional.ofNullable(deliveryRepository.findOne(deliveryId));
    }

    public void deleteDeliveryById(Integer deliveryId) {
        findDeliveryById(deliveryId).ifPresent(delivery -> deliveryRepository.delete(delivery));
    }

}
