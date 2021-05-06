package com.fullstack.sales.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.sales.dto.SellerDTO;
import com.fullstack.sales.entities.Seller;
import com.fullstack.sales.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAllSellers() {
		
		List<Seller> result = repository.findAll();		
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}

}
