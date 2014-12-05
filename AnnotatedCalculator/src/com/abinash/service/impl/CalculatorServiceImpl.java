package com.abinash.service.impl;

import org.springframework.stereotype.Service;

import com.abinash.model.Calculator;
import com.abinash.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public Calculator addAndMultiplyNumbers(Calculator calculator) {
		// TODO Auto-generated method stub
		calculator.setAddResult(calculator.getAdd1()+calculator.getAdd2());
		calculator.setMultResult(calculator.getMult1()*calculator.getMult2());
		return calculator;
	}

}
