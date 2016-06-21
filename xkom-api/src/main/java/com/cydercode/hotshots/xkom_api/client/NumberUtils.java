package com.cydercode.hotshots.xkom_api.client;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtils {

	public static Optional<Double> getDoubleFromText(String text) {
		Pattern pattern = Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
		Matcher matcher = pattern.matcher(text);
		if(!matcher.find()) {
			return Optional.empty();
		}
		
		return Optional.of(Double.parseDouble(matcher.group()));
	}
}
