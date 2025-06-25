package com.book.BookShop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.BookShop.model.User;

public interface UserRepo extends JpaRepository<User, Long>  {
	 User findByEmail(String email);
}
