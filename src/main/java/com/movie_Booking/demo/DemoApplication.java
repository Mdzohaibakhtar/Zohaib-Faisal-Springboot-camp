package com.movie_Booking.demo;

import com.movie_Booking.demo.model.Comment;
import com.movie_Booking.demo.model.Post;
import com.movie_Booking.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	private static PostRepository postRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);



	}




}
