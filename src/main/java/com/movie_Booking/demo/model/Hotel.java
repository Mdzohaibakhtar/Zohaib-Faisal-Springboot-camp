package com.movie_Booking.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 30, name = "hotel_title")
    private String name;
    private String hotelAddress;
    private boolean hotelAvailability;
    private double pricePerNight;
    private int starRating;
    private int availableRooms;
    private String amenities;

}
