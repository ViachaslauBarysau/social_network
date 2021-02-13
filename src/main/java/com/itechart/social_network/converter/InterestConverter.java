package com.itechart.social_network.converter;

import com.itechart.social_network.dto.InterestDto;
import com.itechart.social_network.entity.Interest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InterestConverter {
    public InterestDto entityToDto(Interest interest) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(interest, InterestDto.class);
    }

    public Interest dtoToEntity(InterestDto interestDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(interestDto, Interest.class);
    }

    public List<InterestDto> entityToDto(List<Interest> pathDistanceList) {
        return pathDistanceList.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public List<Interest> dtoToEntity(List<InterestDto> interestDtoList) {
        return interestDtoList.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }
}
