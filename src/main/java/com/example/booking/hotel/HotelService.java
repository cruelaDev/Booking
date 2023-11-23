package com.example.booking.hotel;

import com.example.booking.hotel.dto.HotelCreateDto;
import com.example.booking.hotel.dto.HotelResponseDto;
import com.example.booking.hotel.dto.HotelUpdateDto;
import com.example.booking.hotel.entity.Hotel;
import com.example.booking.hotel.room.RoomRepository;
import com.example.booking.hotel.room.entity.Room;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelDtoMapper hotelDtoMapper;
    private final RoomRepository roomRepository;

    @Transactional
    public List<HotelResponseDto> getAllHotels() {
        List<Hotel> all = hotelRepository.findAll();
        return hotelDtoMapper.toResponseDtos(all);

    }

    @Transactional
    public void create(HotelCreateDto hotelCreateDto) throws IOException {
        MultipartFile picture = hotelCreateDto.getPicture();

        String fileName = UUID.randomUUID() + picture.getOriginalFilename();

        byte[] bytes = picture.getBytes();
        String base64Img = Base64.getEncoder().encodeToString(bytes);

        Hotel hotel = hotelDtoMapper.toEntity(hotelCreateDto);
        hotel.setFileName(fileName);
        hotel.setContentType(picture.getContentType());
        hotel.setImg(base64Img);
        hotelRepository.save(hotel);
    }

    @Transactional
    public HotelResponseDto getById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
        return hotelDtoMapper.toResponseDto(hotel);
    }

    public List<Room> getRooms(Integer id, Integer roomCount, LocalDateTime startDate, LocalDateTime endDate) {
        return roomRepository.findAvailableRooms(id, roomCount, startDate, endDate);
    }

    public ResponseEntity<Resource> downloadFile(Integer id, HttpServletResponse response) throws IOException {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
        byte[] decode = Base64.getDecoder().decode(hotel.getImg().getBytes());
        ByteArrayResource byteArrayResource = new ByteArrayResource(decode);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(hotel.getContentType()))
                .body(byteArrayResource);
    }

    @Transactional
    public void update(Integer id, @RequestBody HotelUpdateDto updateDto) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
        hotel.setName(updateDto.getName());
        hotel.setCity(updateDto.getCity());
    }
}
