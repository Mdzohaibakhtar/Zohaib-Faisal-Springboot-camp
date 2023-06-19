package com.movie_Booking.demo.service;

import com.movie_Booking.demo.model.Hotel;
import com.movie_Booking.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService  {
    private HotelRepository repository;
    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }


    @Override
    public Hotel addHotel(Hotel hotel) {
        return repository.save(hotel);


    }

    @Override
    public List<Hotel> getHotels() {
        return repository.findAll();
    }

    @Override
    public Optional<Hotel> hotelById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public void deleteHotelById(Long id) {
         repository.deleteById(id);


    }

    @Override
    public List<Hotel> finByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Hotel> finByStarRating(int starRating) {
        return repository.findByStarRating(starRating);
    }

    @Override
    public List<Hotel> findByPricePerNight(double minPrice, double maxPrice) {
        return repository.findByPricePerNightBetween(minPrice,maxPrice);
    }

    @Override
    public List<Hotel> findByAddress(String hoteladdress) {
        return repository.findByHotelAddress(hoteladdress);
    }


}
