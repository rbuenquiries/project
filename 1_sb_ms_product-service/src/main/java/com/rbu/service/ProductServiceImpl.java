package com.rbu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbu.dao.ProductRepository;
import com.rbu.dto.ProductDto;
import com.rbu.entity.Product;

@Service
public class ProductServiceImpl implements ProductServiceInterface {
	@Autowired
	ProductRepository repository;

	@Override
	public ProductDto createProduct(ProductDto dto) {
		Product product = new Product();
		mapToEntity(dto, product);
		product = repository.save(product);
		dto.setProductId(product.getProductId());
		return dto;
	}

	private void mapToEntity(ProductDto dto, Product product) {
		product.setProductId(dto.getProductId());
		product.setProductName(dto.getProductName());
		product.setProductDescription(dto.getProductDescription());
		product.setProductColor(dto.getProductColor());
	}

}
