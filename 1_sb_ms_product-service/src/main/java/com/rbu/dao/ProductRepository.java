package com.rbu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbu.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	

}
