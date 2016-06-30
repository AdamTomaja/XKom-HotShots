package com.cydercode.hotshots.xkom_api.client.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cydercode.hotshots.xkom_api.client.XKomClientException;

public class HotShotUrlExtractor {

	private static final Pattern pattern = Pattern.compile("window\\.location = \"(/goracy_strzal/(\\d+))\"");
	
	public static String extractUrl(String pageSource) {
		Matcher m = pattern.matcher(pageSource);
		if(!m.find()) {
			throw new XKomClientException("Cannot find hot shot id");
		}
		
		return m.group(1);
	}
}
