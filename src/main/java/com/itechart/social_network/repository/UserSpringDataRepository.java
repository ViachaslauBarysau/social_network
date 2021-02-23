package com.itechart.social_network.repository;

import com.itechart.social_network.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static com.itechart.social_network.constant.Constants.*;

@ConditionalOnProperty(prefix = REPOSITORY, name = IMPLEMENTATION, havingValue = DATA)
@Primary
public interface UserSpringDataRepository extends UserRepository, JpaRepository<User, Long> {
}
