package com.raphaelsolarski.postoffice.repository;

import com.raphaelsolarski.postoffice.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}
