package com.cydercode.hotshots.xkom_api;

public class XKomClient {

	private final HttpClient client = new HttpClient();
	
	public HotShot fetchCurrentHotShot() {
		try {
			final String pageSource = client.downloadPageSource("http://x-kom.pl");
			System.out.println(pageSource);
		} catch (Exception e) {
			throw new XKomClientException("Cannot get x-kom page source", e);
		}
		return HotShot.createBuilder().withProductName("Cos tam").build();
	}
}
