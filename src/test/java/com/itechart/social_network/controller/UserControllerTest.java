package com.itechart.social_network.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.social_network.dto.InterestDto;
import com.itechart.social_network.dto.UserDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.itechart.social_network.constant.Constants.*;
import static com.jayway.restassured.RestAssured.given;

public class UserControllerTest extends ControllerTest {
    public static final String WRONG_USERS_URL = "/userss";
    public static final String TEST_NAME = "TestName";
    public static final String INTEREST_TEST_NAME = "InterestTestName";
    public static final int INDEX = 0;

//    @Test
//    public void getUsersTestStatusCodeOk() {
//        given().when().get(USERS_URL).then().assertThat().statusCode(STATUS_CODE_200);
//    }
//
//    @Test
//    public void getUsersTestStatusCode404() {
//        given().when().get(WRONG_USERS_URL).then().assertThat().statusCode(STATUS_CODE_404);
//    }
//
//    @Test
//    public void getUserTestContentType() {
//        given().when().get(USERS_URL).then().contentType(APPLICATION_JSON);
//    }
//
//    @Test
//    public void getUsersTestPayloadClass() {
//        given().when().get(USERS_URL).getClass().equals(ArrayList.class);
//    }
//
//    @Test
//    public void testPostUser() throws JsonProcessingException {
//        UserDto testedUserDto = getTestUser();
//        ObjectMapper mapper = new ObjectMapper();
//        UserDto responseUserDto = given().body(mapper.writeValueAsString(testedUserDto)).contentType(APPLICATION_JSON).when()
//                .post(USERS_URL).then()
//                .extract().as(UserDto.class);
//        assert responseUserDto.getName().equals(testedUserDto.getName());
//        assert responseUserDto.getInterests().get(INDEX).getName().equals(testedUserDto.getInterests().get(INDEX).getName());
//        removeTestUser(responseUserDto);
//        removeTestInterests(responseUserDto.getInterests());
//    }
//
//    private UserDto getTestUser() throws JsonProcessingException {
//        return UserDto.builder()
//                .name(TEST_NAME)
//                .interests(new ArrayList<>(Arrays.asList(getTestInterest())))
//                .build();
//    }
//
//    private InterestDto getTestInterest() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        InterestDto testInterestDto = InterestDto.builder()
//                .name(INTEREST_TEST_NAME)
//                .build();
//        return given().body(mapper.writeValueAsString(testInterestDto)).contentType(APPLICATION_JSON).when()
//                .post(INTERESTS_URL).as(InterestDto.class);
//    }

}
