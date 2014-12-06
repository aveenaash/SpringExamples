package com.students.contoller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.students.domain.Student;

@Controller
@RequestMapping(value="/registration")	
public class StudentController {
	
	    @RequestMapping(method=RequestMethod.GET)	
	    public String showForm(@ModelAttribute("student") Student student, Model model){	    	
 	        return "registration";
	    }
	
	    @RequestMapping(method=RequestMethod.POST)	
	    public String processForm( @ModelAttribute("student") @Valid Student student,BindingResult bindingResult,
	    							Model model){
	    	if(bindingResult.hasErrors())
	    	{
	    		return "registration";
	    	}
	    	model.addAttribute("student",student);
            return "success";
 
	
	    }
	    
	}

	

