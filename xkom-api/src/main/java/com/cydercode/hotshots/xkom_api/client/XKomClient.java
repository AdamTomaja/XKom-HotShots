package com.cydercode.hotshots.xkom_api.client;

import com.cydercode.hotshots.xkom_api.client.parser.XKomParser;
import com.cydercode.hotshots.xkom_api.model.HotShot;

/**
 * @author Adam Tomaja (CyderCode)
 */
public class XKomClient {

	private static final String PAGE_URL = "http://x-kom.pl";
	
	private final HttpClient client = new HttpClient();
	private final XKomParser parser = new XKomParser();
	
	public HotShot fetchCurrentHotShot() {
		try {
			final String pageSource = client.downloadPageSource(PAGE_URL);
			return parser.parseHotsHot(pageSource);
		} catch (Exception e) {
			throw new XKomClientException("Cannot get x-kom page source", e);
		}
	}
}
