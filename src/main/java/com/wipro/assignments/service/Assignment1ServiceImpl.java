package com.wipro.assignments.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

/**
 * @author TA351940
 * This class has a method which reads a file from the given filepath and write it in the console
 */
@Service
public class Assignment1ServiceImpl {

	// Decalre the path of the file to read
	private static final String filePath = "D:\\STS\\Assignments\\Assignment1.txt";

	/**
	 * This method read the file and output the content in the console
	 */
	public void readFile() {

		FileReader reader = null;
		BufferedReader bufferedReader = null;
		String s = "";

		try {
			reader = new FileReader(filePath);
			bufferedReader = new BufferedReader(reader);
			while ((s = bufferedReader.readLine()) != null) {
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
