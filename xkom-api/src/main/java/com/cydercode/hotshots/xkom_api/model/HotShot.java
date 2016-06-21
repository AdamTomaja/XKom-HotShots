package com.cydercode.hotshots.xkom_api.model;

/**
 * @author Adam Tomaja (CyderCode)
 */
public class HotShot {

	public static class Builder {

		private HotShot shot = new HotShot();

		private Builder() {
		}

		public Builder withProductName(String productName) {
			shot.productName = productName;
			return this;
		}

		public Builder withOldPrice(String oldPrice) {
			shot.oldPrice = oldPrice;
			return this;
		}

		public Builder withNewPrice(String newPrice) {
			shot.newPrice = newPrice;
			return this;
		}
		
		public Builder withImageUrl(String imageUrl) {
			shot.imageUrl = imageUrl;
			return this;
		}

		public Builder withDiscount(String discountPercent) {
			shot.discount = discountPercent;
			return this;
		}

		public Builder withEndHour(String string) {
			shot.endHour = string;
			return this;
		}

		public HotShot build() {
			return shot;
		}
	}

	private String productName;
	private String imageUrl;
	private String oldPrice;
	private String newPrice;
	private String discount;
	private String endHour;

	private HotShot() {
	}

	public String getProductName() {
		return productName;
	}

	public String getOldPrice() {
		return oldPrice;
	}

	public String getNewPrice() {
		return newPrice;
	}

	public String getDiscount() {
		return discount;
	}

	public String getEndHour() {
		return endHour;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	@Override
	public String toString() {
		return "HotShot [productName=" + productName + ", imageUrl=" + imageUrl + ", oldPrice=" + oldPrice
				+ ", newPrice=" + newPrice + ", discount=" + discount + ", endHour=" + endHour + "]";
	}

	public static Builder createBuilder() {
		return new Builder();
	}
}
