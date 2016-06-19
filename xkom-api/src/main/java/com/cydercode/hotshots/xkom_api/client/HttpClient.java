package com.cydercode.hotshots.xkom_api.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author Adam Tomaja (CyderCode)
 */
public class HttpClient {

	public String downloadPageSource(String pageUrl) throws IOException {
		StringBuilder result = new StringBuilder();
		
		URL url = new URL(pageUrl);

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
