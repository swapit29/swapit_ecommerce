package com.swapit.ecommerce.utility;

import java.util.ArrayList;
import java.util.List;

import com.swapit.ecommerce.dto.ProductDto;
import com.swapit.ecommerce.dto.RatingDto;
import com.swapit.ecommerce.entity.Feedback;
import com.swapit.ecommerce.entity.Product;

public class CommonUtility {

	public static List<ProductDto> getProductsDto(List<Product> products) {
		List<ProductDto> productsDtos = new ArrayList<>();
		for (Product product : products) {
			RatingDto rating = getRatingDto(product.getFeedbacks());
			ProductDto productDto = new ProductDto.Builder().id(product.getId()).name(product.getName())
					.description(product.getDescription()).price(product.getPrice()).brand(product.getBrand())
					.category(product.getCategory()).quantity(product.getQuantity()).discount(product.getDiscount())
					.rating(rating).build();
			productsDtos.add(productDto);
		}
		return productsDtos;
	}

	private static RatingDto getRatingDto(List<Feedback> feedbacks) {
		int noOfRatings = 0;
		int oneRatings = 0;
		int twoRatings = 0;
		int threeRatings = 0;
		int fourRatings = 0;
		int fiveRatings = 0;
		int sumOfRatings = 0;

		for (Feedback feedback : feedbacks) {
			int rating = feedback.getRating().getRating();
			if (rating == 1) {
				oneRatings++;
			} else if (rating == 2) {
				twoRatings++;
			} else if (rating == 3) {
				threeRatings++;
			} else if (rating == 4) {
				fourRatings++;
			} else if (rating == 5) {
				fiveRatings++;
			} else {
				continue;
			}
			sumOfRatings += rating;
			noOfRatings++;
		}
		if (noOfRatings > 0) {
			RatingDto rating = new RatingDto.Builder().noOfRatings(noOfRatings)
					.overallRating(sumOfRatings / noOfRatings).oneRatings(oneRatings * 100 / noOfRatings)
					.twoRatings(twoRatings * 100 / noOfRatings).threeRatings(threeRatings * 100 / noOfRatings)
					.fourRatings(fourRatings * 100 / noOfRatings).fiveRatings(fiveRatings * 100 / noOfRatings).build();
			return rating;
		}
		return new RatingDto.Builder().build();
	}
}
