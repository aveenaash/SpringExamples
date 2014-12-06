package com.abinash.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abinash.form.ProductForm;
import com.abinash.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public String inputForm(Model model) {		
		return "ProductForm";
	}
	
	@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
	public String showResult(Model model, HttpServletRequest request) {		
		ProductForm productForm = new ProductForm();
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(
                request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));        
        model.addAttribute("product", productService.addProduct(productForm));
		return "ProductDetails";
	}
	
}
