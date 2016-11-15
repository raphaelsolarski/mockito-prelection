package com.raphaelsolarski.postoffice.repository;

import com.raphaelsolarski.postoffice.model.CourierCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierCompanyRepository extends JpaRepository<CourierCompany, Integer> {
}
