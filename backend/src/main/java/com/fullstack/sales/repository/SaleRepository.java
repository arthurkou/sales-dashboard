package com.fullstack.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fullstack.sales.dto.SaleSuccessDTO;
import com.fullstack.sales.dto.SaleSumDTO;
import com.fullstack.sales.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query(" SELECT new com.fullstack.sales.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSumDTO> amountGroupedBySeller();

	@Query(" SELECT new com.fullstack.sales.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSuccessDTO> successGroupedBySeller();
}
