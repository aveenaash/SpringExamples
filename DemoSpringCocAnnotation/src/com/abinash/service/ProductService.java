package com.abinash.service;

import org.springframework.stereotype.Service;

import com.abinash.domain.Product;
import com.abinash.form.ProductForm;

@Service
public interface ProductService {
	public Product addProduct(ProductForm p);
}
