package com.abinash.service.implementation;

import org.springframework.stereotype.Component;

import com.abinash.domain.Product;
import com.abinash.form.ProductForm;
import com.abinash.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Override
	public Product addProduct(ProductForm productForm) {
		Product product=new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
        try {
        	product.setPrice(Float.parseFloat(productForm.getPrice()));
        } catch (NumberFormatException e) {
        }
		return product;
	}

}
