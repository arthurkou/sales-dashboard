package com.fullstack.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.sales.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
