package com.atacase.user.service;

import com.atacase.user.dto.UserDto;

public interface UserService {
    void createUser(UserDto userDto);
    UserDto getUser(Long id);
    void updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}
