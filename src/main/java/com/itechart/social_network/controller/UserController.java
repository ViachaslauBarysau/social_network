package com.itechart.social_network.controller;

import com.itechart.social_network.dto.UserDto;
import com.itechart.social_network.service.CalculationService;
import com.itechart.social_network.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

import static com.itechart.social_network.constant.Constants.API_PREFIX;
import static com.itechart.social_network.constant.Constants.USERS_URL;

@RestController
@RequestMapping(value = API_PREFIX + USERS_URL)
public class UserController {
    private final UserService userService;
    private final CalculationService calculationService;

    public UserController(UserService userService, CalculationService calculationService) {
        this.userService = userService;
        this.calculationService = calculationService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto) throws SQLException, IOException {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getUsers() throws SQLException, IOException {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody UserDto userDto) throws SQLException, IOException {
        return new ResponseEntity<>(userService.delete(userDto), HttpStatus.OK);
    }
}
