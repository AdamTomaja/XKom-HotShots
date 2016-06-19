package com.cydercode.hotshots.xkom_api;

import java.math.BigDecimal;
import java.util.Date;

public class HotShot {

	public static class Builder {

		private HotShot shot = new HotShot();

		private Builder() {
		}

		public Builder withProductName(String productName) {
			shot.productName = productName;
			return this;
		}

		public Builder withOldPrice(BigDecimal oldPrice) {
			shot.oldPrice = oldPrice;
			return this;
		}

		public Builder withNewPrice(BigDecimal newPrice) {
			shot.newPrice = newPrice;
			return this;
		}

		public Builder withDiscountPercent(Integer discountPercent) {
			shot.discountPercent = discountPercent;
			return this;
		}

		public Builder withEndDate(Date endDate) {
			shot.endDate = endDate;
			return this;
		}

		public HotShot build() {
			return shot;
		}
	}

	private String productName;
	private BigDecimal oldPrice;
	private BigDecimal newPrice;
	private Integer discountPercent;
	private Date endDate;

	private HotShot() {
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getOldPrice() {
		return oldPrice;
	}

	public BigDecimal getNewPrice() {
		return newPrice;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public Date getEndDate() {
		return endDate;
	}

	@Override
	public String toString() {
		return "HotShot [productName=" + productName + ", oldPrice=" + oldPrice + ", newPrice=" + newPrice
				+ ", discountPercent=" + discountPercent + ", endDate=" + endDate + "]";
	}

	public static Builder createBuilder() {
		return new Builder();
	}
}
