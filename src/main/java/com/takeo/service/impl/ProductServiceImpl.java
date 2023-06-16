package com.takeo.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.takeo.model.Product;

import com.takeo.repo.ProductReepository;
import com.takeo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductReepository productRepo;
	
	
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product> viewProductInfo =  productRepo.findAll();
		return viewProductInfo;
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		
      Product saveEnt = productRepo.save(product);
		
		if(saveEnt!=null)
			return saveEnt;
		else
		return null;
	}

	@Override
	public Product saveOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
     Optional<Product> findById = productRepo.findById(product.getPid());
		
		Product p = findById.get();
		if(p!=null)
		p=productRepo.save(p);
		return p;
		
	}

	@Override
	public boolean deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		 Optional<Product> findById = productRepo.findById(id);
			boolean flag=false;
			Product p = findById.get();
			if(p!=null)
			{
				productRepo.delete(p);
				return true;
			}
		return false;
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
    Optional<Product> findById =	productRepo.findById(id);
		
		Product p = findById.get();
	
	if(p!=null)
		return p;
	else
		return null;
		
	}

}
