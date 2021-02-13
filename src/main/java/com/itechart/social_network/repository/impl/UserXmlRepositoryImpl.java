package com.itechart.social_network.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.itechart.social_network.entity.User;
import com.itechart.social_network.repository.UserRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.List;

@Repository
@ConditionalOnProperty(prefix = "repository", name = "implementation", havingValue = "xml")
public class UserXmlRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() throws IOException {
        return new XmlMapper().readValue(ResourceUtils.getFile("classpath:users.xml"), new TypeReference<>() {
        });
    }
}
