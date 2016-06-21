package com.cydercode.hotshots.xkom_api;

import org.junit.Assert;
import org.junit.Test;

import com.cydercode.hotshots.xkom_api.client.XKomClientException;
import com.cydercode.hotshots.xkom_api.client.parser.EndHourExtractor;

public class EndDateExtractorTest {

	@Test
	public void endDateShouldBeExtracted() {
		String endHour = EndHourExtractor.extract("Hitman.HotShot.init(new Date(2016,5,21,22,0,0), new Date('Tue Jun 21 2016 19:13:39 +0200')");
		Assert.assertEquals("22:00:00", endHour);
	}
	
	@Test(expected = XKomClientException.class)
	public void exceptionShouldBeThrown() {
		EndHourExtractor.extract("Hitman.HotShot.init(new Date(20160,0), new Date('Tue Jun 21 2016 19:13:39 +0200')");
	}
}
