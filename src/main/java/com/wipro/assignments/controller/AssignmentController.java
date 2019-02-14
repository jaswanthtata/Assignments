package com.wipro.assignments.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.assignments.service.Assignment1ServiceImpl;
import com.wipro.assignments.service.Assignment2ServiceImpl;
import com.wipro.assignments.service.Assignment3ServiceImpl;
import com.wipro.assignments.service.Assignment4ServiceImpl;
import com.wipro.assignments.service.Assignment5ServiceImpl;

/**
 * @author TA351940
 * This is a Controller class and defined API's for the assignments
 */
@RestController
public class AssignmentController {
	
	@Autowired
	private Assignment1ServiceImpl assignment1ServiceImpl;
	
	@Autowired
	private Assignment2ServiceImpl assignment2ServiceImpl;
	
	@Autowired
	private Assignment3ServiceImpl assignment3ServiceImpl;
	
	@Autowired
	private Assignment4ServiceImpl assignment4ServiceImpl;
	
	@Autowired
	private Assignment5ServiceImpl assignment5ServiceImpl;
	
	/**
	 * This is API for Assignment1. It is a GET Method
	 */
	@RequestMapping(value = "/assignment1", method = RequestMethod.GET)
	public void Assignment1() {
		
		assignment1ServiceImpl.readFile();
		
	}
	
	/**
	 * This is API for Assignmnet2. It is GET method requesting two parameters
	 * @param a Number1
	 * @param b Number2
	 * @return product of the two numbers
	 */
	@RequestMapping(value = "/assignment2", method = RequestMethod.GET)
	public int assignmnet2(@RequestParam("a") String a,@RequestParam("b") String b) {
		
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		return assignment2ServiceImpl.product(num1, num2);
		
	}
	
	/**
	 *  This is a API for Assignment3. It is POST Method and request a file
	 * @param file It will receive a file.
	 */
	@RequestMapping(value = "/assignment3", method = RequestMethod.POST)
	public void assignmnet3(@RequestParam("file") MultipartFile file) {
		
		System.out.println("file : " + file.getName() + "  " + file.getOriginalFilename() + "  " + file.getContentType());
		assignment3ServiceImpl.uploadFile(file);
		
	}
	
	/**
	 * This is a API for Assignment4. It is a POST method and requests a String
	 * @param request input String is expected
	 * @return the first non-repeating character 
	 */
	@RequestMapping(value = "/assignment4", method = RequestMethod.POST)
	public char assignment4(@RequestBody String request) {
		
		JSONObject object;
		char output = '\0';
		try {
			object = new JSONObject(request);
		String input = object.getString("input");
		output = assignment4ServiceImpl.nonRepeatingChar(input);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return output;
		
	}
	
	/**
	 * This is a API for Assignment5. It is a POST method and requests a url(String)
	 * @param inputUrl url is expected in the String type
	 */
	@RequestMapping(value = "/assignment5", method = RequestMethod.POST)
	public void assignment5(@RequestBody String inputUrl) {
		
		JSONObject object;
		try {
			object = new JSONObject(inputUrl);
			String url = object.getString("input");
			assignment5ServiceImpl.webCrawler(url);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
