package com.cydercode.hotshots.xkom_api;

import com.cydercode.hotshots.xkom_api.client.XKomClient;

/**
 * @author Adam Tomaja (CyderCode)
 */
public class App {
	public static void main(String[] args) {
		System.out.println(new XKomClient().fetchCurrentHotShot());
	}
}
