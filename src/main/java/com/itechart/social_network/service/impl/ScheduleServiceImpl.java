package com.itechart.social_network.service.impl;

import com.itechart.social_network.service.CalculationService;
import com.itechart.social_network.service.ScheduleService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

public class ScheduleServiceImpl implements ScheduleService {
    private final CalculationService calculationService;

    public ScheduleServiceImpl(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @Override
    @Retryable(
            value = {RuntimeException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 3600000))
    @Scheduled(cron = "0 0 9 ? * MON-FRI")
    public void getPairs() throws IOException {
        calculationService.getPairs();
    }
}
