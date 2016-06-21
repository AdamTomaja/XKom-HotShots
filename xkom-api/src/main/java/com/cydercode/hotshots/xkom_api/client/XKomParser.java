package com.cydercode.hotshots.xkom_api.client;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.cydercode.hotshots.xkom_api.model.HotShot;
import com.cydercode.hotshots.xkom_api.model.HotShot.Builder;

/**
 * @author Adam Tomaja (CyderCode)
 */
public class XKomParser {

	private static final String NEW_PRICE_CLASS_NAME = "new-price",
			OLD_PRICE_CLASS_NAME = "old-price",
			DISCOUNT_VALUE_CLASS_NAME = "discount-value",
			PRODUCT_NAME_CLASS_NAME = "product-name",
			CLASS_SELECTOR_FORMAT = "[class=%s]";

	public HotShot parseHotsHot(String pageSource) {
		Document doc = Jsoup.parse(pageSource);
		Builder hotShotBuilder = HotShot.createBuilder();

		hotShotBuilder.withProductName(getTextFromCssClass(doc, PRODUCT_NAME_CLASS_NAME));
		hotShotBuilder.withDiscount(getTextFromCssClass(doc, DISCOUNT_VALUE_CLASS_NAME));
		hotShotBuilder.withOldPrice(getTextFromCssClass(doc, OLD_PRICE_CLASS_NAME));
		hotShotBuilder.withNewPrice(getTextFromCssClass(doc, NEW_PRICE_CLASS_NAME));
		hotShotBuilder.withImageUrl(parseImageUrl(doc));
 		return hotShotBuilder.build();
	}
	
	private String parseImageUrl(Document doc) {
		Elements elements = doc.select("#hotShot .img-responsive");
		ensureElementExists(elements, "image-url");
		return elements.first().attr("src");
	}

	private String getTextFromCssClass(Document doc, String cssClass) {
		Elements elements = doc.select(String.format(CLASS_SELECTOR_FORMAT, cssClass));
		ensureElementExists(elements, cssClass);
		return elements.first().text();
	}
 
	private void ensureElementExists(Elements elements, String name) {
		if(elements.isEmpty()) {
			throw new XKomClientException(String.format("Cannot find %s", name));
		}
	}
}
