package com.example.booking.hotel.entity;

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
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private City city;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
    private String fileName;
    private String contentType;
    @Column(length = Integer.MAX_VALUE)
    private String img;
}
