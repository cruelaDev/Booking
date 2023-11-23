package com.example.booking.hotel.dto;

import com.example.booking.address.City;
import com.example.booking.hotel.room.entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponseDto {
    private Integer id;
    private String name;
    private City city;
    private List<Room> rooms;
    private String fileName;
}
