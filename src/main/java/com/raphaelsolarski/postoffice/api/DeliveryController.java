package com.raphaelsolarski.postoffice.api;

import com.raphaelsolarski.postoffice.model.Delivery;
import com.raphaelsolarski.postoffice.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping(method = RequestMethod.GET, path = "/{deliveryId}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Integer deliveryId) {
        return deliveryService.findDeliveryById(deliveryId)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Delivery> saveOrUpdateDelivery(@RequestBody Delivery delivery) {
        return deliveryService.addOrUpdateDelivery(delivery)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{deliveryId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDeliveryById(@PathVariable Integer deliveryId) {
        deliveryService.deleteDeliveryById(deliveryId);
    }

}