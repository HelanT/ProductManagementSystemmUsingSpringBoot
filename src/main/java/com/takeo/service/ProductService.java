package com.takeo.service;

import java.util.List;



import com.takeo.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product addProduct(Product product);
	
	public Product saveOrUpdateProduct(Product product);
	
	public boolean deleteProduct(Integer id);
	
	public Product getProductById(Integer id);

}
