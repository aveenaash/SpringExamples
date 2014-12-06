/**
 * 
 */
package com.students.domain;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.students.validator.IntegerDigit;

/**
 * @author B.Pirasanth
 *
 */

public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@IntegerDigit (length=3, message="Area must be 3 digit long")
 	private int area;
 	
	@IntegerDigit (length=3, message="Prefix must be 3 digit")
 	private int prefix;
	
	@IntegerDigit (length=4, message="Number must be 4 digit")
 	private int number;
 
	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

 	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrefix() {
		return prefix;
	}

	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}
}
