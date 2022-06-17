package com.productsDB.productsDB.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productsDB.productsDB.models.Brand;

public interface BrandRepo extends JpaRepository<Brand, UUID> {

}
