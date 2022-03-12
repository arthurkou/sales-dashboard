package com.fullstack.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.sales.dto.SaleDTO;
import com.fullstack.sales.dto.SaleSuccessDTO;
import com.fullstack.sales.dto.SaleSumDTO;
import com.fullstack.sales.service.SaleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAllSales(Pageable pageable) {
		Page<SaleDTO> sales = service.findAllSales(pageable);
		
		return ResponseEntity.ok(sales);
	}

	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> amountBySeller = service.amountGroupedBySeller();
		
		return ResponseEntity.ok(amountBySeller);
	}
	
	@GetMapping(value = "/success-sales")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
		List<SaleSuccessDTO> successSales = service.successGroupedBySeller();
		
		return ResponseEntity.ok(successSales);
	}
}
