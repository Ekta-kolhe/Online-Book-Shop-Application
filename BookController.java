package com.book.BookShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.BookShop.model.Book;
import com.book.BookShop.repo.BookRepository;
@CrossOrigin
@RestController
@RequestMapping("books")
public class BookController {
	@Autowired
BookRepository bookRepo;
	 @GetMapping
	    public List<Book> getAllBooks() {
	        return bookRepo.findAll();
	    }
}
