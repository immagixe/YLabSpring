package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.mapper.UserMapper;
import com.edu.ulab.app.service.UserService;
import com.edu.ulab.app.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final Storage storage;
    private final UserMapper userMapper;

    public UserServiceImpl(Storage storage, UserMapper userMapper) {
        this.storage = storage;
        this.userMapper=userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setId(idGenerator.getNewUserId());
        User user = userMapper.userDtoToUser(userDto);
        storage.saveUser(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        storage.saveUser(user);
        return userDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = storage.getUserById(id);
        return userMapper.userToUserDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        storage.deleteUserById(id);
    }
}
