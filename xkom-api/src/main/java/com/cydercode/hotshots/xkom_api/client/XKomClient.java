package com.cydercode.hotshots.xkom_api.client;

import com.cydercode.hotshots.xkom_api.model.HotShot;

public class XKomClient {

	private final HttpClient client = new HttpClient();
	private final XKomParser parser = new XKomParser();
	
	public HotShot fetchCurrentHotShot() {
		try {
			final String pageSource = client.downloadPageSource("http://x-kom.pl");
			System.out.println(pageSource);
			return parser.parseHotsHot(pageSource);
		} catch (Exception e) {
			throw new XKomClientException("Cannot get x-kom page source", e);
		}
	}
}
