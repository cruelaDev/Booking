package com.example.booking.hotel.room;

import com.example.booking.hotel.HotelRepository;
import com.example.booking.hotel.entity.Hotel;
import com.example.booking.hotel.room.dto.RoomCreateDto;
import com.example.booking.hotel.room.entity.Room;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomDtoMapper roomDtoMapper;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public void create(RoomCreateDto roomCreateDto) {
        Room room = roomDtoMapper.toEntity(roomCreateDto);
        Hotel hotel = hotelRepository.findById(roomCreateDto.getHotelId()).orElseThrow();
        room.setHotel(hotel);
        roomRepository.save(room);
    }

    @Transactional
    public Integer delete(Integer id) {
        Integer hotelId = roomRepository.findById(id).orElseThrow().getHotel().getId();
        roomRepository.deleteById(id);
        return hotelId;
    }
}
