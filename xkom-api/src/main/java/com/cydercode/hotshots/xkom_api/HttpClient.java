package com.cydercode.hotshots.xkom_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpClient {

	public String downloadPageSource(String pageUrl) throws IOException {
		StringBuilder result = new StringBuilder();
		
		URL url = new URL(pageUrl);
		
		System.out.println(url.toString());
		
		//Download page
		InputStream inputStream = null;
		BufferedReader bufferedReader;
		String line;
		
		inputStream = url.openStream();		
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		
		while((line = bufferedReader.readLine()) != null) {
			result.append(line);
			result.append(System.lineSeparator());
		}
		
		bufferedReader.close();
		
		return result.toString();
	}	
}
