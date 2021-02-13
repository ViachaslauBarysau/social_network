package com.itechart.social_network.service;

import com.itechart.social_network.dto.UserDto;
import com.itechart.social_network.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserDto> getUsers() throws IOException;
}
