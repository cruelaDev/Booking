package com.example.booking.hotel.room;

import com.example.booking.hotel.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("""
            from Room room
            left join room.books book
            left join room.hotel hotel
            where 
            hotel.id = :hotelId
            and room.roomCount = :roomCount
            and (book is null)
            or not(
            (book.startDate <= :startDate and  :startDate < book.endDAte) 
            and 
            (:startDate <= book.startDate and book.startDate < :endDate)
            ) order by room.number
            """)

    List<Room> findAvailableRooms(Integer hotelId,
                                  Integer roomCount,
                                  LocalDateTime startDate,
                                  LocalDateTime endDate);
}
