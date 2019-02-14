package com.wipro.assignments.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author TA351940
 * This class has a method which expects a file and store it into local directory
 */
@Service
public class Assignment3ServiceImpl {
	
	// Declare the path to store the file
	private final static String uploadPath = "D:\\STS\\Assignments";
	
	/**
	 * This method expects a file as a parameter
	 * It will read the file and store it in local directory(at the path mentioned above)
	 * @param file
	 */
	public void uploadFile(MultipartFile file) {
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadPath + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
