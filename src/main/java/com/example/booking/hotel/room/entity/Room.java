package com.example.booking.hotel.room.entity;

import com.example.booking.book.entity.Book;
import com.example.booking.hotel.entity.Hotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private Integer roomCount;
    @ManyToOne
    private Hotel hotel;
    @OneToMany(mappedBy = "room")
    private List<Book> books;
}
