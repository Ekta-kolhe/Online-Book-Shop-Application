package com.book.BookShop.model;

import jakarta.persistence.*;

@Entity
public class Book {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String title;
	    private int price;
	 // 👇 Required: No-arg constructor
	    public Book() {
	    	
	    }

	    // 👇 Required: Constructor used in CommandLineRunner
	    public Book(Long id, String title, int price) {
	        this.id = id;
	        this.title = title;
	        this.price = price;
	    }

	    // 👇 Required: Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getTitle() { return title; }
	    public void setTitle(String title) { this.title = title; }

	    public int getPrice() { return price; }
	    public void setPrice(int price) { this.price = price; }
}
