package com.movie_Booking.demo.service;

import com.movie_Booking.demo.model.Hotel;
import com.movie_Booking.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
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
        return repository.findByPricePerNightBetween(minPrice, maxPrice);
    }

    @Override
    public List<Hotel> findByAddress(String hoteladdress) {
        return repository.findByHotelAddress(hoteladdress);
    }

    @Override
    public List<Hotel> findByRooms() {
        return repository.findByAvailableRooms();
    }

    @Override
    public List<Hotel> findByHotelAmenities(String amenities) {
        return repository.findByAmenitiesContains(amenities);
    }

    @Override
    public List<Hotel> findByMinStarMaxPrice(int starRating, double maxPrice) {
        return repository.findByStarRatingGreaterThanEqualAndPricePerNightLessThanEqual(starRating,maxPrice);
    }


    @Override
    public List<Hotel> getHotelsWithinRange(double latitude, double longitude, double rangeInKm) {
        return repository.findHotelsWithinRange(latitude, longitude, rangeInKm);
    }

}



