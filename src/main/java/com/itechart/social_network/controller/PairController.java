package com.itechart.social_network.controller;

import com.itechart.social_network.dto.UserDto;
import com.itechart.social_network.service.CalculationService;
import com.itechart.social_network.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "/api/pairs")
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
