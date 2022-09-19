package com.edu.ulab.app.storage.repository.impl;

import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.storage.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepositoryImpl implements UserRepository {

    Map<Long, User> userMap = new HashMap<>();

    @Override
    public void saveUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User getUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userMap.remove(id);
    }
}
