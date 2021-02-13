package com.itechart.social_network.service.impl;

import com.itechart.social_network.converter.UserConverter;
import com.itechart.social_network.dto.UserDto;
import com.itechart.social_network.repository.UserRepository;
import com.itechart.social_network.repository.UserSpringDataRepository;
import com.itechart.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }
    @Override
    public List<UserDto> getUsers() throws IOException {
        return userConverter.entityToDto(userRepository.findAll());
    }

}
