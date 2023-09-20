package com.product.service;

import java.util.List;

import com.product.model.Product;

public interface ProductService {

	//add product
	public Product addProduct(Product product);
	
	//get single product
	public Product getProduct(Long id);
	
	//get all product
	public List<Product> getAlProduct();
	
	//update product
	public Product updateProduct(Long id, Product productDetails);
	
	//delete product
	
	public void deleteProduct(Long id);
	
	//sort the data the range between
    public List<Product> getProductsInPriceRange(double minPrice, double maxPrice);
   
    //sort the data in Ascending order
    public List<Product> getProductsSortedByPriceAsc();
    
    //sort the data in Descending order
    public List<Product> getProductsSortedByPriceDesc();


    
    
    
    
}
