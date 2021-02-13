package com.itechart.social_network.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.social_network.entity.User;
import com.itechart.social_network.repository.UserRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
@ConditionalOnProperty(prefix = "repository", name = "implementation", havingValue = "json")
public class UserJsonRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() throws IOException {
        return new ObjectMapper().readValue(ResourceUtils.getFile("classpath:users.json"), new TypeReference<>() {
        });
    }
}
