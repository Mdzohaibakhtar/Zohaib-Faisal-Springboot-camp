package com.movie_Booking.demo.controller;

import com.movie_Booking.demo.model.Hotel;
import com.movie_Booking.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels/api")
public class HotelController {

    private HotelService hotelService;
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        Hotel createdhotel = hotelService.addHotel(hotel);
        return new ResponseEntity<>(createdhotel, HttpStatus.CREATED);
    }

    @GetMapping("/getallhotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        Optional<Hotel> existingHotel = hotelService.hotelById(id);
        if (existingHotel.isPresent()) {
            hotel.setId(id);
            Hotel updatedHotel = hotelService.updateHotel(hotel);
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long id){
        Optional<Hotel> existingHotel = hotelService.hotelById(id);
        if (existingHotel.isPresent()) {

            hotelService.deleteHotelById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Successfully");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found for deletion");
        }
    }
    @GetMapping("/{hotelbyname}")
    public ResponseEntity<?> getHotelByName(@PathVariable String hotelbyname ) {
        List<Hotel> hotels = hotelService.finByName(hotelbyname);

        if(!hotels.isEmpty()){
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found in Hotel DB");
        }


    }
    @GetMapping("/hotelrating/{starrating}")
    public ResponseEntity<?>getHotelByStarRating(@PathVariable int starrating){
        List<Hotel> hotels = hotelService.finByStarRating(starrating);

        if(!hotels.isEmpty()){
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Data not found in Hotel DB"));
        }
    }

    @GetMapping("/hotelprice/{minprice}/{maxprice}")
    public ResponseEntity<?>getHotelByPriceRange(@PathVariable double minprice, @PathVariable double maxprice){
        List<Hotel> hotels = hotelService.findByPricePerNight(minprice,maxprice);

        if(!hotels.isEmpty()){
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Data not found in Hotel DB"));
        }
    }
    @GetMapping("/address/{hoteladdress}")
    public ResponseEntity<?>getHotelByAddress(@PathVariable String hoteladdress){
        List<Hotel> hotels = hotelService.findByAddress(hoteladdress);

        if(!hotels.isEmpty()){
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Data not found in Hotel DB"));
        }
    }
    @GetMapping("/availablerooms")
    public ResponseEntity<?>getHotelByAvailableRooms(){
        List<Hotel> hotels = hotelService.findByRooms();

        if(!hotels.isEmpty()){
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Data not found in Hotel DB"));
        }
    }
    @GetMapping("/amenities/{hotelamenities}")
    public ResponseEntity<?>getHotelAmenities(@PathVariable String hotelamenities){
        List<Hotel> hotels = hotelService.findByHotelAmenities(hotelamenities);

        if(!hotels.isEmpty()){
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Data not found in Hotel DB"));
        }
    }

    @GetMapping("/pl")
    public ResponseEntity<?>getHotelWithinRange(@RequestParam double latitude,@RequestParam double longitude,@RequestParam double kms){
        List<Hotel> hotels = hotelService.getHotelsWithinRange(latitude,longitude,kms);

        if(!hotels.isEmpty()){
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Data not found in Hotel DB"));
        }

    }
    @GetMapping("/hotelstarprice")
    public ResponseEntity<?>getHotelMinStarMaxPrice(@RequestParam int minstar, @RequestParam double maxprice){
        List<Hotel> hotels = hotelService.findByMinStarMaxPrice(minstar,maxprice);

        if(!hotels.isEmpty()){
            return new ResponseEntity<>(hotels,HttpStatus.OK);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found in Hotel DB");
        }
    }

}
