package com.example.booking.hotel.room;

import com.example.booking.hotel.room.dto.RoomCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public String createRoom(@ModelAttribute RoomCreateDto roomCreateDto) {
        roomService.create(roomCreateDto);
        return "redirect:/hotel/%d/update".formatted(roomCreateDto.getHotelId());
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Integer id) {
        Integer hotelId = roomService.delete(id);
        return "redirect:/hotel/%d/update".formatted(hotelId);
    }
}
