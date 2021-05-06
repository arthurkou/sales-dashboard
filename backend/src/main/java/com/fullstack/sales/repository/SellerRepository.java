package com.fullstack.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.sales.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}
