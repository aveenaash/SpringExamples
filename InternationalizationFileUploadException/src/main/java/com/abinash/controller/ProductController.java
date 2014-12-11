package com.abinash.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abinash.domain.Product;
import com.abinash.exception.ImageFileNullException;
import com.abinash.exception.ImageUploadFailedException;

@Controller
@RequestMapping("/")
public class ProductController {

	@RequestMapping(method = RequestMethod.GET)
	public String inputForm(@ModelAttribute("product") Product product,
			Model model) {
		return "ProductForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String showResult(@ModelAttribute("product") Product product,
			Model model, BindingResult bindingResult, HttpServletRequest request) {

		MultipartFile productImage = product.getProductImage();
		System.out.println("Original Filename"
				+ productImage.getOriginalFilename());
		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");
		System.out.println(rootDirectory);

		if (productImage != null && !productImage.isEmpty()) {
			try {
				int dotIndex = productImage.getOriginalFilename().lastIndexOf(
						".");
				String ext = productImage.getOriginalFilename().substring(
						dotIndex);				
				productImage.transferTo(new File(rootDirectory
						+ "/resources/images/" + product.getName() + ext));
			} catch (Exception e) {
				throw new ImageUploadFailedException();
			}
		}
		else
		{
			throw new ImageFileNullException();
		}
		return "ProductDetails";
	}
	
	@ExceptionHandler(ImageUploadFailedException.class)
    public ModelAndView handleImageUploadFailedException(HttpServletRequest request, Exception ex){
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());         
        modelAndView.setViewName("error");
        return modelAndView;
    }
	
	@ExceptionHandler(ImageFileNullException.class)
    public ModelAndView handleImageFileNullException(HttpServletRequest request, Exception ex){
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());         
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
