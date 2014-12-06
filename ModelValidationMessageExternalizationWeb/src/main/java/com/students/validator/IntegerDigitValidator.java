package com.students.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntegerDigitValidator implements ConstraintValidator<IntegerDigit, Integer> {
	
	private int lengthCount;

	public void initialize(IntegerDigit constraintAnnotation) {
		this.lengthCount = constraintAnnotation.length();
		
	}

	public boolean isValid(Integer value, ConstraintValidatorContext arg1) {
		String a = String.valueOf(value);
		if (a.length() == this.lengthCount) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
