package com.example.booking.book;

import com.example.booking.book.dto.BookCreateDto;
import com.example.booking.book.entity.Book;
import com.example.booking.hotel.room.RoomRepository;
import com.example.booking.hotel.room.entity.Room;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final RoomRepository roomRepository;

    public void create(BookCreateDto createDto) {
        Room room = roomRepository.findById(createDto.getRoomId()).orElseThrow();
        Book book = new Book(null, room, createDto.getStartDate(), createDto.getEndDate());
        bookRepository.save(book);
    }
}
