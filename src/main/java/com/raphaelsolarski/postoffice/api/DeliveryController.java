package com.raphaelsolarski.postoffice.api;

import com.raphaelsolarski.postoffice.model.Delivery;
import com.raphaelsolarski.postoffice.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping(method = RequestMethod.GET, path = "{deliveryId}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Integer deliveryId) {
        return deliveryService.findDeliveryById(deliveryId)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //TODO can it be add or update?
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Delivery> saveOrUpdateDelivery(Delivery delivery) {
        return deliveryService.addOrUpdateDelivery(delivery)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<Delivery>(HttpStatus.CONFLICT));
        //TODO I'm not sure that conflict is ok.
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{deliveryId}")
    public void deleteDeliveryById(@PathVariable Integer deliveryId) {
        //TODO I should return some kind of status
        deliveryService.deleteDeliveryById(deliveryId);
    }

}