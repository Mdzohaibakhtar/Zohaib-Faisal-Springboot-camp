package com.movie_Booking.demo.model;
import jakarta.persistence.*;
import lombok.*;

import java.security.PrivateKey;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="tbl_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 30)
    private String name;
    private String Gender;
    private String Address;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 9)
    private int SSN;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 5)
    private int hotelBookingId;
    private String bookingStatus;
    private float dateOfCheckIn;
    private float dateOfCheckOut;

}
