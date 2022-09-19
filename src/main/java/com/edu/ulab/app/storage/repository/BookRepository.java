package com.edu.ulab.app.storage.repository;

import com.edu.ulab.app.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getBookListById(Long id);

    void saveBookList(List<Book> bookList, Long userId);

    void deleteBookListById(Long id);
}
