package com.raphaelsolarski.postoffice.repository;

import com.raphaelsolarski.postoffice.model.CourierCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CourierCompanyRepository extends JpaRepository<CourierCompany, Integer> {
    String FIND_BY_PROVINCE_QUERY = "FROM CourierCompany cc WHERE cc.address.province = :province";

    @Query(FIND_BY_PROVINCE_QUERY)
    Optional<CourierCompany> findByProvince(@Param("province") String province);
}
