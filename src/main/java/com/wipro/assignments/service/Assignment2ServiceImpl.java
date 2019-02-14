package com.wipro.assignments.service;

import org.springframework.stereotype.Service;

/**
 * @author TA351940
 * This class has a method which expects the two numbers as parameters and return the product
 */
@Service
public class Assignment2ServiceImpl {
	
	public int product(int num1, int num2) {
		int result = num1 * num2;
		System.out.println("Product of two numbers is : " + result);
		return result;
	}

}
