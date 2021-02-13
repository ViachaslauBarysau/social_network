package com.itechart.social_network.service;

import com.itechart.social_network.dto.PairDto;

import java.io.IOException;
import java.util.List;

public interface CalculationService {
    List<PairDto> getPairs() throws IOException;
}
