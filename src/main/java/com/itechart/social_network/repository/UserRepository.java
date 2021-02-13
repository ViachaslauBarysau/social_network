package com.itechart.social_network.repository;

import com.itechart.social_network.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserRepository {
    List<User> findAll() throws IOException;
}
