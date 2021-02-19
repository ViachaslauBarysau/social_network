package com.itechart.social_network.controller;

import com.itechart.social_network.dto.InterestDto;
import com.itechart.social_network.service.InterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static com.itechart.social_network.constant.Constants.API_PREFIX;
import static com.itechart.social_network.constant.Constants.INTERESTS_URL;

@RestController
@RequestMapping(value = API_PREFIX + INTERESTS_URL)
public class InterestController {
    private final InterestService interestService;

    public InterestController(InterestService interestService) {
        this.interestService = interestService;
    }

    @DeleteMapping
    public ResponseEntity deleteInterests(@RequestBody List<InterestDto> interestDtoList) throws SQLException, IOException {
        return new ResponseEntity<>(interestService.delete(interestDtoList), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addInterest(@RequestBody InterestDto interestDto) throws SQLException, IOException {
        return new ResponseEntity<>(interestService.add(interestDto), HttpStatus.OK);
    }
}
