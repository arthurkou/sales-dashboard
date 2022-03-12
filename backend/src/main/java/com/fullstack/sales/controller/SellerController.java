package com.fullstack.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.sales.dto.SellerDTO;
import com.fullstack.sales.service.SellerService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/sellers")
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAllSellers() {
		List<SellerDTO> sellers = service.findAllSellers();
		
		return ResponseEntity.ok(sellers);
	}

}
