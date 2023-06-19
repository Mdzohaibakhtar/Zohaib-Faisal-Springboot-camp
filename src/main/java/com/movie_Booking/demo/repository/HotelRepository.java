package com.movie_Booking.demo.repository;

import com.movie_Booking.demo.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    //1.find by name
    List<Hotel> findByName(String name);
    //2.find hotels by star rating
    List<Hotel> findByStarRating(int starRating);
    //3.find hotel within a specific price range
    List<Hotel> findByPricePerNightBetween(double minPrice, double maxPrice);
    //4.find a hotel in a specific city
    List<Hotel> findByHotelAddress(String hoteladdress);

}
