package com.movie_Booking.demo.repository;

import com.movie_Booking.demo.model.Hotel;
import com.movie_Booking.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
