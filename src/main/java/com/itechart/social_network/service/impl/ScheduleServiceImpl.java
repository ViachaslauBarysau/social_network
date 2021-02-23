package com.itechart.social_network.service.impl;

import com.itechart.social_network.service.CalculationService;
import com.itechart.social_network.service.ScheduleService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

public class ScheduleServiceImpl implements ScheduleService {
    public static final String SCHEDULE_CRON = "0 0 9 ? * MON-FRI";
    public static final int DELAY = 3600000;
    public static final int MAX_ATTEMPTS = 5;
    private final CalculationService calculationService;

    public ScheduleServiceImpl(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @Override
    @Retryable(
            value = {RuntimeException.class},
            maxAttempts = MAX_ATTEMPTS,
            backoff = @Backoff(delay = DELAY))
    @Scheduled(cron = SCHEDULE_CRON)
    public void getPairs() throws IOException {
        calculationService.getPairs();
    }
}
