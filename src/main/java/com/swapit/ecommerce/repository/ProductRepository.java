package com.swapit.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.swapit.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategory(String category);
	Page<Product> findAll(Pageable pageable);

}
