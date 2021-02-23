package com.itechart.social_network.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.social_network.entity.User;
import com.itechart.social_network.repository.UserRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.List;

import static com.itechart.social_network.constant.Constants.*;

@Repository
@ConditionalOnProperty(prefix = REPOSITORY, name = IMPLEMENTATION, havingValue = JSON)
public class UserJsonRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() throws IOException {
        return new ObjectMapper()
                .readValue(ResourceUtils.getFile(CLASSPATH + DOUBLE_DOT + USERS + DOT + JSON),
                        new TypeReference<>() {
                        });
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(User user) {
    }
}
