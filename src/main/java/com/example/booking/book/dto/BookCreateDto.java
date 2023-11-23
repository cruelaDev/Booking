package com.example.booking.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDto {
    private Integer roomId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
