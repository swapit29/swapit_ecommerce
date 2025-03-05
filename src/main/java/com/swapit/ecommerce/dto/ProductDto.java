package com.swapit.ecommerce.dto;

public class ProductDto {

	private long id;
	private String name;
	private String description;
	private long price;
	private String brand;
	private String category;
	private long quantity;
	private int discount; // Percentage
	private RatingDto rating;

	ProductDto(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.description = builder.description;
		this.price = builder.price;
		this.brand = builder.brand;
		this.category = builder.category;
		this.quantity = builder.quantity;
		this.discount = builder.discount;
		this.rating = builder.rating;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public long getPrice() {
		return price;
	}

	public String getBrand() {
		return brand;
	}

	public String getCategory() {
		return category;
	}

	public long getQuantity() {
		return quantity;
	}

	public int getDiscount() {
		return discount;
	}

	public RatingDto getRating() {
		return rating;
	}

	public static class Builder {
		private long id;
		private String name;
		private String description;
		private long price;
		private String brand;
		private String category;
		private long quantity;
		private int discount; // Percentage
		private RatingDto rating;

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder price(long price) {
			this.price = price;
			return this;
		}

		public Builder brand(String brand) {
			this.brand = brand;
			return this;
		}

		public Builder category(String category) {
			this.category = category;
			return this;
		}

		public Builder quantity(long quantity) {
			this.quantity = quantity;
			return this;
		}

		public Builder discount(int discount) {
			this.discount = discount;
			return this;
		}

		public Builder rating(RatingDto rating) {
			this.rating = rating;
			return this;
		}

		public ProductDto build() {
			return new ProductDto(this);
		}
	}
}
