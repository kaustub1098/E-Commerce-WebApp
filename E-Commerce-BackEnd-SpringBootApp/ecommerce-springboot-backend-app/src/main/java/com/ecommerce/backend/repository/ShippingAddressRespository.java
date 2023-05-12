package com.ecommerce.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.backend.entities.ShippingAddressEntity;

public interface ShippingAddressRespository extends JpaRepository<ShippingAddressEntity, Long> {

}
