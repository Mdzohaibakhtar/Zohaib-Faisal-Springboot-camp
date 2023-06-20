package com.movie_Booking.demo.repository;

import com.movie_Booking.demo.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    // 5. Find hotels with available rooms:
    @Query(value = "SELECT h FROM Hotel h WHERE h.availableRooms > 0")
    List<Hotel> findByAvailableRooms();

    //    6. Find hotels with a specific amenity:
    List<Hotel> findByAmenitiesContains(String amenities);

    //    7. Find hotels with a minimum number of stars and a maximum price:
    List<Hotel> findByStarRatingGreaterThanEqualAndPricePerNightLessThanEqual(int starRating, double maxPrice);

    //    8. Find hotels with a specific rating or higher:
    List<Hotel> findByStarRatingGreaterThanEqual(int starRating);

    //    9. Find hotels ordered by their star rating in descending order:
    List<Hotel> findAllByOrderByStarRatingDesc(int starRating);

    //    10. Find hotels with a specific rating and within a city:
    List<Hotel> findByStarRatingAndHotelAddress(int starRating, String city);

    //    11. Find hotels with a specific Hotel name or address:
    List<Hotel> findByNameOrHotelAddress(String name, String address);

    //    12. Find hotels with a specific rating or in a specific city:
    List<Hotel> findByStarRatingOrName(int starRating, String cityName);

    //    13. Find hotels with a specific name and price range:
    List<Hotel> findByNameAndPricePerNightBetween(String name, double minPrice, double maxPrice);

    //    14. Find hotels with names containing a specific keyword:
    List<Hotel> findByNameContaining(String keyword);

    //    15. Find hotels with names starting with a specific letter:
    List<Hotel> findByNameStartingWith(String letter);

    //    16. Find hotels with names ending with a specific letter:
    List<Hotel> findByNameEndingWith(String letter);

    //    17. Find hotels with names containing a specific keyword in a specific city:
    List<Hotel> findByNameContainingAndCity(String keyword, String hotelAddress);

    //    18. Find hotels with names containing a specific keyword, sorted by their price in ascending order:
    List<Hotel> findByNameContainingOrderByPricePerNightAsc(String keyword);

    //    19. Find hotels with names containing a specific keyword, limited to a certain number of results:
    List<Hotel> findTop5ByNameContaining(String keyword);

    // 20. Find hotels within a specific location radius: Using Haversine formula
    @Query(value = "SELECT h FROM Hotel h WHERE " +
            "(6371 * 2 * ASIN(" +
            "SQRT(" +
            "POWER(SIN(RADIANS(:yourLatitude - h.latitude) / 2), 2) + COS(RADIANS(:yourLatitude)) * COS(RADIANS(h.latitude)) * POWER(SIN(RADIANS(:yourLongitude - h.longitude) / 2), 2)" +
            ")" +
            ")) <= :yourRangeInKm")
    List<Hotel> findHotelsWithinRange(@Param("yourLatitude") Double yourLatitude,
                                      @Param("yourLongitude") Double yourLongitude,
                                      @Param("yourRangeInKm") Double yourRangeInKm);
}
