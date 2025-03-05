package com.swapit.ecommerce.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.swapit.ecommerce.dto.FeedbackDto;
import com.swapit.ecommerce.dto.ProductDto;
import com.swapit.ecommerce.entity.Feedback;
import com.swapit.ecommerce.entity.Product;
import com.swapit.ecommerce.entity.Rating;
import com.swapit.ecommerce.entity.Review;
import com.swapit.ecommerce.entity.User;
import com.swapit.ecommerce.exception.ProductInvalidException;
import com.swapit.ecommerce.repository.ProductRepository;
import com.swapit.ecommerce.utility.CommonUtility;

@Service
public class ProductService {

	private final String URL = "http://localhost:8081/getUserDetails/";
	ProductRepository repo;
	RestTemplate restTemplate;

	public ProductService(ProductRepository repo, RestTemplate restTemplate) {
		this.repo = repo;
		this.restTemplate = restTemplate;
	}

	public Product addProduct(Product product) {
		return repo.save(product);
	}

	public Product fetchProductById(long productId) {
		return repo.findById(productId).orElseThrow(() -> new ProductInvalidException("Product Not Found"));
	}

	public List<ProductDto> fetchProducts() {
		List<Product> products = repo.findAll();
		return CommonUtility.getProductsDto(products);
	}

	public List<Product> fetchProductsByCategory(String category) {
		return repo.findByCategory(category);
	}

	public void addProductFeedback(FeedbackDto feedbackDto) {
		Product product = fetchProductById(feedbackDto.getProductId());
		List<Feedback> feedbacks = product.getFeedbacks();
		Feedback feedback = new Feedback();
		User user = restTemplate.getForEntity(URL + feedbackDto.getUserId(), User.class).getBody();
		Rating rating = new Rating(feedbackDto.getRating());
		Review review = new Review(feedbackDto.getComment());
		feedback.setRating(rating);
		feedback.setReview(review);
		feedback.setUserId(user.getId());
		feedback.setUserName(user.getName());
		feedbacks.add(feedback);
		product.setFeedbacks(feedbacks);
		repo.save(product);
		System.out.println(product.toString());
	}
}
