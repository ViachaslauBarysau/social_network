package com.itechart.social_network.service;

import com.itechart.social_network.dto.InterestDto;
import com.itechart.social_network.dto.UserDto;

import java.util.List;

public interface InterestService {
    List<Long> delete(List<InterestDto> interestDtoList);
    InterestDto add(InterestDto interestDto);
}
