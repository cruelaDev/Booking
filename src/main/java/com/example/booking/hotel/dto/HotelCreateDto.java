package com.example.booking.hotel.dto;

import com.example.booking.address.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelCreateDto {
    private City city;
    private String name;
    private MultipartFile picture;
}
