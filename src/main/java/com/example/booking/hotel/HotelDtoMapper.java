package com.example.booking.hotel;

import com.example.booking.hotel.dto.HotelCreateDto;
import com.example.booking.hotel.dto.HotelResponseDto;
import com.example.booking.hotel.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HotelDtoMapper {
    private final ModelMapper modelMapper;

    public HotelResponseDto toResponseDto(Hotel hotel) {
        return modelMapper.map(hotel, HotelResponseDto.class);
    }

    public List<HotelResponseDto> toResponseDtos(List<Hotel> hotels) {
        return hotels
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public Hotel toEntity(HotelCreateDto hotelCreateDto) {
        return modelMapper.map(hotelCreateDto, Hotel.class);
    }
}
