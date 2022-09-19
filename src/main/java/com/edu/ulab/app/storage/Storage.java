package com.edu.ulab.app.storage;

import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.storage.repository.BookRepository;
import com.edu.ulab.app.storage.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Storage {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public Storage(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public void saveBookList(List<Book> bookList, Long userId) {
        bookRepository.saveBookList(bookList,userId);
    }

    public List<Book> getBookListById(Long id) {
        return bookRepository.getBookListById(id);
    }

    public void deleteBookListById(Long id) {
        bookRepository.deleteBookListById(id);
    }

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }
}
