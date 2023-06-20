package com.movie_Booking.demo.service;

import com.movie_Booking.demo.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    public Hotel addHotel(Hotel hotel);
    public List<Hotel> getHotels();
    public Optional<Hotel> hotelById(Long id);
    public Hotel updateHotel(Hotel hotel);
    public void deleteHotelById(Long id);
    public List<Hotel> finByName(String name);
    public List<Hotel> finByStarRating(int starRating);
    public List<Hotel> findByPricePerNight(double minPrice, double maxPrice);
    public List<Hotel> findByAddress(String hoteladdress);

    public List<Hotel> getHotelsWithinRange(double latitude, double longitude, double rangeInKm) ;
}
