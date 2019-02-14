package com.wipro.assignments;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.assignments.service.Assignment5ServiceImpl;

public class Assignment5Testcases {
	
	@Autowired
	private Assignment5ServiceImpl assignment5ServiceImpl; 
	
	@Test
	public void webCrawlerTest() {
		assignment5ServiceImpl.parseDocumet("www.wiprodigital.com");
	}

}
