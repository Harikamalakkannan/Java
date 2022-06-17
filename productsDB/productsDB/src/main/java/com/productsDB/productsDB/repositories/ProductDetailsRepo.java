package com.productsDB.productsDB.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;

import com.productsDB.productsDB.models.ProductDetails;

public interface ProductDetailsRepo  extends JpaRepository<ProductDetails, UUID>{
	
	List<ProductDetails> findAllByOrderByUpdatedOnDesc();
}
