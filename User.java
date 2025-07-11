package com.book.BookShop.model;
//import org.hibernate.annotations.NotFound;




import org.hibernate.annotations.NotFound;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	    private Long id;
	 
	    private String name;

	
	   
	    @Column(unique = true)
	    private String email;

	    private String password;

	    // Constructors
	    public User() {}

	    public User(String name, String email, String password) {
	        this.name = name;
	        this.email = email;
	        this.password = password;
	    }

	    // Getters and setters
	    public Long getId() { return id; }

	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }

	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }

	    public void setEmail(String email) { this.email = email; }

	    public String getPassword() { return password; }

	    public void setPassword(String password) { this.password = password; }
}
