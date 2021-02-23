package com.itechart.social_network.controller;

import com.itechart.social_network.service.CalculationService;
import com.itechart.social_network.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

import static com.itechart.social_network.constant.Constants.API_PREFIX;
import static com.itechart.social_network.constant.Constants.PAIRS_URL;

@RestController
@RequestMapping(value = API_PREFIX + PAIRS_URL)
public class PairController {
    private final UserService userService;
    private final CalculationService calculationService;

    public PairController(UserService userService, CalculationService calculationService) {
        this.userService = userService;
        this.calculationService = calculationService;
    }

    @GetMapping
    public ResponseEntity getPairs() throws SQLException, IOException {
        return new ResponseEntity<>(calculationService.getPairs(), HttpStatus.OK);
    }
}
