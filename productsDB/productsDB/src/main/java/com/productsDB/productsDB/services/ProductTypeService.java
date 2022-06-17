package com.productsDB.productsDB.services;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.productsDB.productsDB.models.Brand;
import com.productsDB.productsDB.models.CategoryType;
import com.productsDB.productsDB.models.ProductDetails;
import com.productsDB.productsDB.models.ProductType;
import com.productsDB.productsDB.repositories.BrandRepo;
import com.productsDB.productsDB.repositories.CategoryTypeRepo;
import com.productsDB.productsDB.repositories.ProductDetailsRepo;
import com.productsDB.productsDB.repositories.ProductTypeRepo;

@Service
public class ProductTypeService {
	
	
	@Autowired
	 ProductTypeRepo productType;

	// method for find all product types in DB
	public Object getAllProductType() {
		return productType.findAll();
	}
	
	
	// method for creating a new product type in DB
	public Object createProducctType(ProductType newproductType) {

		return productType.save(newproductType);
	}

	// Service for product details
	@Autowired
	ProductDetailsRepo productDetaiL̥lsRepo;
	
	public List<ProductDetails> getAllProducts() throws IllegalArgumentException {
		
		return  productDetailsRepo.findAllByOrderByUpdatedOnDesc();	}

	public Object createProduct(ProductDetails newProduct) {

		return productDetailsRepo.save(newProduct);// send some message
	}

	public void deleteProduct(UUID productId) {

		productDetailsRepo.deleteById(productId);
	}

	public void updateProduct(ProductDetails newProduct) {
		productDetailsRepo.save(newProduct);
	}

	public Object getOneProduct(UUID productId) {

		return productDetailsRepo.findById(productId);
	}

	// service for category type
	@Autowired
	CategoryTypeRepo categoryType;

	// get all category from the database
	public Object getAllCategory() {
		return categoryType.findAll();// findAll(built-in) method in JPA Repository)

	}

	// create a new category
	public Object createCategory(CategoryType category) {

		return categoryType.save(category);// findAll(built-in) method in JPA Repository)
	}

	// delete a category
	public String deleteCategory(UUID categoryTypeId) {
		categoryType.deleteById(categoryTypeId);
		return "Delete Successfully Completed";
	}

	// service for brand tables.
	@Autowired
	BrandRepo brandRepo;

	public Object createBrand(Brand newBrand) {
		return brandRepo.save(newBrand);

	}

	public Object getAllBrand() {
		return brandRepo.findAll();
	}
}
