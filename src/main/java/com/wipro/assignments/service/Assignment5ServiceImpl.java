package com.wipro.assignments.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

/**
 * @author TA351940
 * This class has methods to parse the document, html and return the links of other pages
 */
@Service
public class Assignment5ServiceImpl {
	
	/**
	 * This method expects a URL in a String format and call parseDocument and parseHtml methods 
	 * @param url
	 */
	public void webCrawler(String url) {
		
		Document document = parseDocumet(url);
		if(document != null) {
			parseHtml(document);
		}
		
	}
	
	/**
	 * This method expects the url as a parameter, parse and return the document 
	 * @param url
	 * @return doc
	 */
	public static Document parseDocumet(String url){
		System.out.println("parsing the documet "+ url);
		Document doc = null;
		//Parsing the Documment from the given url
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	/**
	 * This method expects document as a parameter and parse it and call the print method to print the links 
	 * @param document
	 */
	public static void parseHtml(Document document) {
		//Parse the HTML and get the tags and the data 
		Elements links = document.select("a[href]");
		Elements media = document.select("[src]");
		Elements imports = document.select("link[href]");

		//print the link,images, media in the console
		print("Images that are present :","abs:src",media);
		print("Imports : ","abs:href",imports);
		print("Links : ","abs:href",links);
	}
	
	/**
	 * This method will print the message and loop through the elements and print the links 
	 * @param msg
	 * @param attrMsg
	 * @param element
	 */
	public static void print(String msg,String attrMsg,Elements element) {
		System.out.println("\n"+msg+" : "+ element.size());
		for (Element link : element) {
			System.out.println(link.tagName()+" : "+link.attr(attrMsg));
		}
	}
	

}
