package com.example.booking.hotel.dto;

import com.example.booking.address.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelUpdateDto {
    private String name;
    private City city;
}
