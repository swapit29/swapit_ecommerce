package com.swapit.ecommerce.dto;

public class RatingDto {

	private int noOfRatings;
	private double overallRating;
	private int oneRatings; // in percentage
	private int twoRatings;
	private int threeRatings;
	private int fourRatings;
	private int fiveRatings;

	public RatingDto(Builder builder) {
		this.noOfRatings = builder.noOfRatings;
		this.overallRating = builder.overallRating;
		this.oneRatings = builder.oneRatings;
		this.twoRatings = builder.twoRatings;
		this.threeRatings = builder.threeRatings;
		this.fourRatings = builder.fourRatings;
		this.fiveRatings = builder.fiveRatings;
	}

	public int getNoOfRatings() {
		return noOfRatings;
	}

	public double getOverallRating() {
		return overallRating;
	}

	public int getOneRatings() {
		return oneRatings;
	}

	public int getTwoRatings() {
		return twoRatings;
	}

	public int getThreeRatings() {
		return threeRatings;
	}

	public int getFourRatings() {
		return fourRatings;
	}

	public int getFiveRatings() {
		return fiveRatings;
	}

	public static class Builder {
		private int noOfRatings;
		private int overallRating;
		private int oneRatings;
		private int twoRatings;
		private int threeRatings;
		private int fourRatings;
		private int fiveRatings;

		public Builder noOfRatings(int noOfRatings) {
			this.noOfRatings = noOfRatings;
			return this;
		}

		public Builder overallRating(int overallRating) {
			this.overallRating = overallRating;
			return this;
		}

		public Builder oneRatings(int oneRatings) {
			this.oneRatings = oneRatings;
			return this;
		}

		public Builder twoRatings(int twoRatings) {
			this.twoRatings = twoRatings;
			return this;
		}

		public Builder threeRatings(int threeRatings) {
			this.threeRatings = threeRatings;
			return this;
		}

		public Builder fourRatings(int fourRatings) {
			this.fourRatings = fourRatings;
			return this;
		}

		public Builder fiveRatings(int fiveRatings) {
			this.fiveRatings = fiveRatings;
			return this;
		}

		public RatingDto build() {
			return new RatingDto(this);
		}
	}
}
