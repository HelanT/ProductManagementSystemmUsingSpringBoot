package com.takeo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.takeo.model.Product;
import com.takeo.service.impl.ProductServiceImpl;

@Controller
public class ProductController {
	
	@Autowired
	public ProductServiceImpl productService;
	
	
	
	@RequestMapping("/")
	public String home(Product product, Model model)
	{
	
		return "index.html";
		
	}
	@RequestMapping("/add_product")
	public String showAddForm(Product product, Model model)
	{
		model.addAttribute("product", product);
		return "add-product.html";
		
	}
	
	@RequestMapping("/available_products")
	public ModelAndView getAllProducts(Product product, Model model) {
		
    List<Product> allProducts = productService.getAllProducts();
	 
    return new ModelAndView("productlist.html","product", allProducts);
    
	
	}
	
	@PostMapping("/save")
	public String handleForm(@ModelAttribute Product product, Model model)
	{
		Product addProduct = productService.addProduct(product);	
		return "redirect:/available_products";
	}
	
	
	
	@RequestMapping(path = {"/delete/{id}"})
	public String delete(@PathVariable("id") Integer id)
	{
		
	    productService.deleteProduct(id);
	    
	    return "redirect:/available_products";
	}

	@RequestMapping(path= {"/update/{id}"})
	public String update(Model model,@PathVariable("id") Integer id) 
	{
		Product product =productService.getProductById(id);
		
		model.addAttribute("product", product);
		
		return "edit-product.html";
		
	}
	
	



	

	
	

}
