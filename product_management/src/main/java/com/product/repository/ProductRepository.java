package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//sort the data the range between
	List<Product> findByPriceBetween(double minPrice, double maxPrice);
	
	//sort the data in Ascending order
    List<Product> findByOrderByPriceAsc();
    
  //sort the data in Descending order
    List<Product> findByOrderByPriceDesc();

}
