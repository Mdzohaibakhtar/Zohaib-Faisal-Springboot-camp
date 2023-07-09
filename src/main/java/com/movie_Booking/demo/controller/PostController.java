package com.movie_Booking.demo.controller;

import com.movie_Booking.demo.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class PostController {

    // Inject Service Layer Here

    @PostMapping
    public ResponseEntity<Post> addPost(){
        // create variable and use service method
        return new ResponseEntity<>( /*Put variable here....*/, HttpStatus.OK) ;
    }

    @GetMapping("/getPosts")
    public ResponseEntity<Post> getPost(){
        // create variable and use service method
        return new ResponseEntity<>(/*Put variable here....*/, HttpStatus.OK);
    }
}
