package com.packt.webstore.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
 
	@RequestMapping
	public String list(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
	
	@RequestMapping("/all")
	public ModelAndView allProducts() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("customers", customerService.getAllCustomers());
		modelAndView.setViewName("customers");
		return modelAndView;
	}
	
	
	@RequestMapping("/customer")
	public String getProductById(Model model, @RequestParam("id") String id) {
		Customer customer = customerService.get(Long.parseLong(id));
		model.addAttribute("customer", customer);
		return "customer";
	}
	
	@RequestMapping("/{firstName}")
	public String getProductsByCategory(Model model, @PathVariable("firstName") String firstName) {
		List<Customer> customers =customerService.getCustomersByFirstName(firstName);
		if (customers == null || customers.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}

		model.addAttribute("customers", customers);
		return "customers";
	}

//	@RequestMapping("/customer")
//	public String getProductByFirstName(Model model, @RequestParam("firstName") String firstName) {
//		Customer customer = customerService.g
//		model.addAttribute("customer", customer);
//		return "customer";
//	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newCustomer") Customer newCustomer) {
	   return "addCustomer";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newCustomer") @Valid Customer customerToBeAdded, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addCustomer";
		}

		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
			
		try {
		customerService.addCustomer(customerToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}		
	   	return "redirect:/customers";
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("invalidProductId", exception.getProductId());
		 mav.addObject("exception", exception);
		 mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		 mav.setViewName("productNotFound");
		 return mav;
	}
	
	
}
