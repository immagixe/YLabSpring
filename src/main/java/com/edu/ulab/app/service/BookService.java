package com.edu.ulab.app.service;


import com.edu.ulab.app.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> createBookList(List<BookDto> bookDtoList, Long userId);

    List<BookDto> getBookListByUserId(Long id);

    void deleteBookListByUserId(Long id);
}
