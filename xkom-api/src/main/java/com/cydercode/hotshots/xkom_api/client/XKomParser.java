package com.cydercode.hotshots.xkom_api.client;

import java.math.BigDecimal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.cydercode.hotshots.xkom_api.model.HotShot;
import com.cydercode.hotshots.xkom_api.model.HotShot.Builder;

public class XKomParser {

	public HotShot parseHotsHot(String pageSource) {
		Document doc = Jsoup.parse(pageSource);
		Builder hotShotBuilder = HotShot.createBuilder();

		hotShotBuilder.withProductName(getTextFromCssClass(doc, "product-name"));
		hotShotBuilder.withDiscountPercent(parsePercent(getTextFromCssClass(doc, "discount-value")));
		hotShotBuilder.withOldPrice(parseBigInteger(getTextFromCssClass(doc, "old-price")));
		hotShotBuilder.withNewPrice(parseBigInteger(getTextFromCssClass(doc, "new-price")));

 		return hotShotBuilder.build();
	}
	
	private BigDecimal parseBigInteger(String textWithPlnLetters) {
		String substring = textWithPlnLetters.substring(0, textWithPlnLetters.length() - 3);
		System.out.println(substring);
		return new BigDecimal(substring.replace(",", "."));
	}
	
	private int parsePercent(String textWithPercentSign) {
		return Integer.valueOf(textWithPercentSign.substring(0, textWithPercentSign.length() - 1));
	}
	
	private String getTextFromCssClass(Document doc, String cssClass) {
		Elements elements = doc.select(String.format("[class=%s]", cssClass));
		ensureElementExists(elements, cssClass);
		return elements.first().text();
	}
 
	private void ensureElementExists(Elements elements, String name) {
		if(elements.isEmpty()) {
			throw new XKomClientException(String.format("Cannot find %s", name));
		}
	}
}
