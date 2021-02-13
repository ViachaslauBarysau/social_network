package com.itechart.social_network.repository;

import com.itechart.social_network.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@ConditionalOnProperty(prefix = "repository", name = "implementation", havingValue = "data")
@Primary
public interface UserSpringDataRepository extends UserRepository, JpaRepository<User, Long> {
    List<User> findAll();
}
