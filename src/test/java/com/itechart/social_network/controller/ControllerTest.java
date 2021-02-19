package com.itechart.social_network.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.social_network.dto.InterestDto;
import com.itechart.social_network.dto.UserDto;
import com.jayway.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

import static com.itechart.social_network.constant.Constants.*;
import static com.jayway.restassured.RestAssured.given;

public class ControllerTest {
    @BeforeAll
    public static void setup() {
        String port = System.getProperty(SERVER_PORT);
        if (port == null) {
            RestAssured.port = Integer.parseInt(PORT);
        } else {
            RestAssured.port = Integer.parseInt(port);
        }

        String basePath = System.getProperty(SERVER_BASE);
        if (basePath == null) {
            basePath = API_PREFIX;
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty(SERVER_HOST);
        if (baseHost == null) {
            baseHost = BASE_URL;
        }
        RestAssured.baseURI = baseHost;
    }

    public void removeTestUser(UserDto userDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        given().body(mapper.writeValueAsString(userDto)).contentType(APPLICATION_JSON).when().delete(USERS_URL);
    }

    public void removeTestInterests(List<InterestDto> interestDtoList) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        given().body(mapper.writeValueAsString(interestDtoList)).contentType(APPLICATION_JSON).when()
                .delete(INTERESTS_URL);
    }
}
