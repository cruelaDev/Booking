package com.example.booking.hotel.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomCreateDto {
    private Integer number;
    private Integer roomCount;
    private Integer hotelId;
}
