package com.example.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.dto.BookResponse;
import com.example.model.Book;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BookMapper {
    private final ModelMapper modelMapper;
    public BookResponse toBookResponse(Book book) {
        return modelMapper.map(book, BookResponse.class);
    }
}
