package com.edu.ulab.app.storage.repository;

import com.edu.ulab.app.entity.User;

public interface UserRepository {
    void saveUser(User user);

    User getUserById(Long id);

    void deleteUserById(Long id);
}
