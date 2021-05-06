package com.fullstack.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack.sales.dto.SaleDTO;
import com.fullstack.sales.entities.Sale;
import com.fullstack.sales.repository.SaleRepository;
import com.fullstack.sales.repository.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAllSales(Pageable pageable) {
		
		sellerRepository.findAll();
		
		Page<Sale> result = saleRepository.findAll(pageable);		
		return result.map(x -> new SaleDTO(x));
	}

}
