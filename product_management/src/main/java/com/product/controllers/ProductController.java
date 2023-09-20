package com.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.service.ProductService;
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	//get single product
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Long id)
	{
		return service.getProduct(id);
	}
	
	//get all products
	@GetMapping("/all")
	public List<Product> getAllProducts()
	{
		return service.getAlProduct();
	}
	
	//create a product
	@PostMapping("/add")
	public Product createProduct(@RequestBody Product product)
	{
		return service.addProduct(product);
	}

	//update product
	 @PutMapping("/{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        return service.updateProduct(id, product);
	    }
	 
	 
	 //delete product
	 @DeleteMapping("/{id}")
	 public void deleteProduct(@PathVariable("id") Long id)
	 {
		 service.deleteProduct(id);
	 }
	 
	 
	 @GetMapping("/price-range")
	    public List<Product> getProductsInPriceRange(
	        @RequestParam(name = "minPrice") double minPrice,
	        @RequestParam(name = "maxPrice") double maxPrice) {
	        return service.getProductsInPriceRange(minPrice, maxPrice);
	    }

	    @GetMapping("/sorted-asc")
	    public List<Product> getProductsSortedByPriceAsc() {
	        return service.getProductsSortedByPriceAsc();
	    }

	    @GetMapping("/sorted-desc")
	    public List<Product> getProductsSortedByPriceDesc() {
	        return service.getProductsSortedByPriceDesc();
	    }
}
