package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.mapper.BookMapper;
import com.edu.ulab.app.service.BookService;
import com.edu.ulab.app.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private final Storage storage;
    private final BookMapper bookMapper;

    public BookServiceImpl(Storage storage, BookMapper bookMapper) {
        this.storage = storage;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> createBookList(List<BookDto> bookDtoList, Long userId) {
        bookDtoList=bookDtoList.stream().peek(bookDto -> bookDto.setId(idGenerator.getNewBookId())).toList();
        List<Book> books = bookDtoList.stream().map(bookMapper::bookDtoToBook).toList();
        storage.saveBookList(books,userId);
        return bookDtoList;
    }

    @Override
    public List<BookDto> getBookListByUserId(Long id) {
        return storage.getBookListById(id).stream().map(bookMapper::bookToBookDto).toList();
    }

    @Override
    public void deleteBookListByUserId(Long id) {
        storage.deleteBookListById(id);
    }
}
