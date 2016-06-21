package com.cydercode.hotshots.xkom_api;

import org.junit.Assert;
import org.junit.Test;

import com.cydercode.hotshots.xkom_api.client.NumberUtils;

/**
 * @author Adam Tomaja (CyderCode)
 */
public class NumberUtilTest {

	@Test
	public void getNumberShouldGiveEmpty() {
		Assert.assertFalse(NumberUtils.getDoubleFromText("asdasjdo jasjd").isPresent());
	}
	
	@Test
	public void getNumberShouldGiveSomething() {
		Assert.assertTrue(NumberUtils.getDoubleFromText("asdasjdo 23.23 jasjd").isPresent());
	}
	
	@Test
	public void getNumberShouldGiveExactNumber() {
		Assert.assertEquals(new Double(12.0d), NumberUtils.getDoubleFromText("asdoajsodjasd 12 asijdai %").get());
	}
	
	@Test
	public void getNumberShouldGiveExactNumberWithFloatingPoint() {
		Assert.assertEquals(new Double(12.543d), NumberUtils.getDoubleFromText("asdoajsodjasd 12.543 asijdai %").get());
	}
}
