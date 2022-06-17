package com.productsDB.productsDB.controlers;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productsDB.productsDB.models.Brand;
import com.productsDB.productsDB.models.CategoryType;
import com.productsDB.productsDB.models.ProductDetails;
import com.productsDB.productsDB.models.ProductType;
import com.productsDB.productsDB.services.ProductTypeService;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductTypeControler {
	

	@Autowired
	ProductTypeService productTypeService;

	// product type controller
	@GetMapping(value = "/getAllProductType")
	public Object getAllProducttype() {

		return productTypeService.getAllProductType();	}
	
	@PostMapping(value="/createNewProductType")
	public Object createProductType(@RequestBody ProductType newType) {
		
		return productTypeService.createProducctType(newType);
	}
	
			
	// product details controller
	@GetMapping(value="/getAllProducts")
	public Object getAllproducts() throws IllegalArgumentException{
	
		return productTypeService.getAllProducts();
		
	}
	
	@PostMapping(value="/createProduct")
	public Object createProduct( @RequestBody ProductDetails newProduct) {
		 
		return productTypeService.createProduct(newProduct);
	}
	
	@DeleteMapping(value="/deleteOneProduct")
	public String deleteOneProduct(@RequestParam UUID productId) {
		
		productTypeService.deleteProduct(productId);
		
		return " Product Deleted Succcessfully";
	}
	
	@PostMapping(value="/updateProduct")
	public Object updateProduct(@RequestBody ProductDetails newProduct) {
		
		productTypeService.createProduct(newProduct);
		return newProduct;
	}
	
	@GetMapping(value="/getProductById")
	public Object getOneProduct(@RequestParam UUID productId) {
		return productTypeService.getOneProduct(productId);
	}
	
//	category type controller
	
	@PostMapping(value="/createCategory")
	public Object createCategory(@RequestBody CategoryType newCategory) {
		
		return productTypeService.createCategory(newCategory);//createCategory()-resides in service class
		
	}
	
	@GetMapping(value="/getAllCategory")
	public Object getAllCategory() {
		return  productTypeService.getAllCategory();
	}
	
	
	
// brand controller
	
	@GetMapping(value="/getAllBrands")
	public Object getAllBrands() {
		
		return productTypeService.getAllBrand();
	}
	
	@PostMapping(value="/createBrand")
	public Object createBrand(@RequestBody Brand newBrand) {
		
		return productTypeService.createBrand(newBrand);
	}
	
}
