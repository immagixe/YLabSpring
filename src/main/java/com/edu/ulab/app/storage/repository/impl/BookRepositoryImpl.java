package com.edu.ulab.app.storage.repository.impl;

import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.storage.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookRepositoryImpl implements BookRepository {

    Map<Long, List<Book>> bookMap = new HashMap<>();

    @Override
    public void saveBookList(List<Book> bookList, Long userId) {
        bookMap.put(userId, bookList);
    }

    @Override
    public List<Book> getBookListById(Long userId) {
        return bookMap.get(userId);
    }

    @Override
    public void deleteBookListById(Long userId) {
        bookMap.remove(userId);
    }
}
