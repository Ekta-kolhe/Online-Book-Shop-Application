package com.book.BookShop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.BookShop.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
