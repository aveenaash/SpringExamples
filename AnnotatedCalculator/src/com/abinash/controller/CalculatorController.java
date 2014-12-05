package com.abinash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.abinash.model.Calculator;
import com.abinash.service.CalculatorService;

@Controller
@SessionAttributes("calcresult") 
public class CalculatorController {
	
	@Autowired
	CalculatorService calculatorService;
	
	@RequestMapping("/")
	public String showCalculatorForm()
	{
		return "calculator";
	}
	
	@RequestMapping("/calculate")
	public String calculateResults(Calculator calc, Model model)
	{
		Calculator c=calculatorService.addAndMultiplyNumbers(calc);
		model.addAttribute("calcresult", c);
		return "redirect:showresult";
	}
	
	//The /calculate is calling addAndMultiplyNumbers(calc); and passing the Calculator object to 
	// to /showresult by saving it in session to make use of PRG and then in /showresult it is again passed 
	// to model attribute so that it can be displayed in result.jsp and session is removed
	
	@RequestMapping("/showresult")
	public String showResult(Model model, SessionStatus status)
	{
		Calculator calc=(Calculator) ((ModelMap)model).get("calcresult");
		model.addAttribute("calculatorResult", calc);
		status.setComplete();
		return "result";
	}
}
