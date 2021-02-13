package com.itechart.social_network.service.impl;

import com.itechart.social_network.repository.InterestRepository;
import com.itechart.social_network.service.InterestService;
import org.springframework.stereotype.Service;

@Service
public class InterestServiceImpl implements InterestService {
    private final InterestRepository interestRepository;

    public InterestServiceImpl(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }
}
