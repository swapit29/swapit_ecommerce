package com.swapit.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.swapit.ecommerce.dto.FeedbackDto;
import com.swapit.ecommerce.dto.ProductDto;
import com.swapit.ecommerce.entity.Product;
import com.swapit.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	ProductService service;

	ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	private ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return ResponseEntity.ofNullable(service.addProduct(product));
	}

	@GetMapping("/fetch/{productId}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<Product> fetchProducts(@PathVariable long productId) {
		return ResponseEntity.ofNullable(service.fetchProductById(productId));
	}

	@GetMapping("/fetch")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<List<ProductDto>> fetchProducts(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		return ResponseEntity.ofNullable(service.fetchProducts(pageNo, pageSize));
	}

	@GetMapping("/fetch/catgory/{category}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<List<Product>> fetchProductsByCategory(@PathVariable String category) {
		return ResponseEntity.ofNullable(service.fetchProductsByCategory(category));
	}

	@PostMapping("/add/feedback")
	@ResponseStatus(HttpStatus.CREATED)
	private void addProduct(@RequestBody FeedbackDto feedbackDto) {
		service.addProductFeedback(feedbackDto);
	}

}
