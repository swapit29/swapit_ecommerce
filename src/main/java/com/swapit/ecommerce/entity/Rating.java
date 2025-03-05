package com.swapit.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rating {

	public Rating(int rating) {
		this.rating = rating;
	}

	public Rating() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private int rating;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + "]";
	}

}
