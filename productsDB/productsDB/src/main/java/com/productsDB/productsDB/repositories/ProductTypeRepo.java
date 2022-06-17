package com.productsDB.productsDB.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.productsDB.productsDB.models.ProductType;

public interface ProductTypeRepo extends JpaRepository<ProductType, UUID> {
		
}
