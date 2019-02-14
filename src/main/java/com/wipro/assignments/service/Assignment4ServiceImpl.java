package com.wipro.assignments.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author TA351940
 *This class has a method takes the String as a parameter and return the first non-repeating character in it. 
 */
@Service
public class Assignment4ServiceImpl {

	public char nonRepeatingChar(String input) {
		char[] charArr = input.toCharArray();
		char res = '\0';
		boolean status;
		List val = new ArrayList();
		for (int i = 0; i < charArr.length; i++) {
			status = false;
			if (!val.contains(charArr[i])) {
				for (int j = i + 1; j < charArr.length; j++) {
					if (charArr[i] == charArr[j] && val.contains(charArr[j]) == false) {
						status = true;
						val.add(charArr[i]);
					}
				}
				if (status == false) {
					res = charArr[i];
					return res;
				}
			}
		}
		return res;
	}

}
