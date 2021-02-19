package com.itechart.social_network.service.impl;

import com.itechart.social_network.converter.InterestConverter;
import com.itechart.social_network.dto.InterestDto;
import com.itechart.social_network.repository.InterestRepository;
import com.itechart.social_network.service.InterestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterestServiceImpl implements InterestService {
    private final InterestRepository interestRepository;
    private final InterestConverter interestConverter;

    public InterestServiceImpl(InterestRepository interestRepository, InterestConverter interestConverter) {
        this.interestRepository = interestRepository;
        this.interestConverter = interestConverter;
    }

    @Override
    public List<Long> delete(List<InterestDto> interestDtoList) {
        for (InterestDto interestDto: interestDtoList
             ) {
            interestRepository.deleteById(interestDto.getId());
        }
        return interestDtoList.stream().map(InterestDto::getId).collect(Collectors.toList());
    }

    @Override
    public InterestDto add(InterestDto interestDto) {
        return interestConverter.entityToDto(interestRepository.save(interestConverter.dtoToEntity(interestDto)));
    }
}
