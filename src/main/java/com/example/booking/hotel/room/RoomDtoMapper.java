package com.example.booking.hotel.room;

import com.example.booking.hotel.room.dto.RoomCreateDto;
import com.example.booking.hotel.room.entity.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomDtoMapper {
    private final ModelMapper modelMapper;

    public Room toEntity(RoomCreateDto roomCreateDto) {
        return modelMapper.map(roomCreateDto, Room.class);
    }
}

