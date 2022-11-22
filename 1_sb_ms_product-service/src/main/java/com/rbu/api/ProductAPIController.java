package com.rbu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbu.dto.ProductDto;
import com.rbu.service.ProductServiceInterface;

@RestController
@RequestMapping("/v1/product")
public class ProductAPIController {
	@Autowired
	ProductServiceInterface productServiceInterface;

	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto){
		dto=productServiceInterface.createProduct(dto);
		return new ResponseEntity<ProductDto>(dto,HttpStatus.CREATED);
	}

}
