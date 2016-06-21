package com.cydercode.hotshots.xkom_api.client.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cydercode.hotshots.xkom_api.client.XKomClientException;

public class EndHourExtractor {

	public static String extract(String pageSource) {
		Pattern pattern = Pattern.compile("init\\(new Date\\(2016\\,5\\,21\\,(\\d+)\\,(\\d+)\\,(\\d+)\\)\\, new Date\\(");
		Matcher matcher = pattern.matcher(pageSource);
		if(!matcher.find()) {
			throw new XKomClientException("Cannot find end hour");
		}
		
		return String.format("%02d:%02d:%02d",groupAsInt(matcher, 1),
				groupAsInt(matcher, 2),
				groupAsInt(matcher, 3));
	}
	
	private static int groupAsInt(Matcher m, int g) {
		return Integer.parseInt(m.group(g));
	}
}
