package com.itechart.social_network.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.social_network.dto.InterestDto;
import com.itechart.social_network.dto.PairDto;
import com.itechart.social_network.dto.UserDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.itechart.social_network.constant.Constants.*;
import static com.jayway.restassured.RestAssured.given;

public class PairControllerTest extends ControllerTest {

    public static final String WRONG_PAIRS_URL = "/pairss";
    public static final String INTEREST_TEST_NAME = "InterestTestName";
    public static final String FIRST_USER_TEST_NAME = "FirstUserTestName";
    public static final String SECOND_USER_TEST_NAME = "SecondUserTestName";
    public static final int STRENGTH_OF_CONNECTION = 1;

//    @Test
//    public void getPairsTestStatusCodeOk() {
//        given().when().get(PAIRS_URL).then().assertThat().statusCode(STATUS_CODE_200);
//    }
//
//    @Test
//    public void getPairsTestStatusCode404() {
//        given().when().get(WRONG_PAIRS_URL).then().assertThat().statusCode(STATUS_CODE_404);
//    }
//
//    @Test
//    public void getPairsTestContentType() {
//        given().when().get(PAIRS_URL).then().contentType(APPLICATION_JSON);
//    }
//
//    @Test
//    public void getPairsTestPayloadClass() {
//        given().when().get(PAIRS_URL).getClass().equals(ArrayList.class);
//    }

//    @Test
//    public void getPairsTestPayload() throws JsonProcessingException {
//        PairDto testPairDto = createTestPairDto();
//        PairDto[] pairs = given().contentType(APPLICATION_JSON)
//                .when().get(PAIRS_URL).as(PairDto[].class);
//        List<PairDto> pairDtoList = new ArrayList<>(Arrays.asList(pairs));
//        assert pairDtoList.contains(testPairDto);
//        removeTestUser(testPairDto.getFirstUser());
//        removeTestUser(testPairDto.getSecondUser());
//        removeTestInterests(testPairDto.getInterests());
//    }
//
//    private PairDto createTestPairDto() throws JsonProcessingException {
//        InterestDto testInterestDto = createTestInterest();
//        return PairDto.builder()
//                .firstUser(getTestUser(testInterestDto, FIRST_USER_TEST_NAME))
//                .secondUser(getTestUser(testInterestDto, SECOND_USER_TEST_NAME))
//                .interests(new ArrayList<>(Collections.singletonList(testInterestDto)))
//                .strengthOfConnection(STRENGTH_OF_CONNECTION)
//                .build();
//    }
//
//    private UserDto getTestUser(InterestDto testInterestDto, String testUserName) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        UserDto testUserDto = UserDto.builder()
//                .name(testUserName)
//                .interests(new ArrayList<>(Collections.singletonList(testInterestDto)))
//                .build();
//        return given().body(mapper.writeValueAsString(testUserDto)).contentType(APPLICATION_JSON).when()
//                .post(USERS_URL).then()
//                .extract().as(UserDto.class);
//    }
//
//    private InterestDto createTestInterest() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        InterestDto testInterestDto = InterestDto.builder()
//                .name(INTEREST_TEST_NAME)
//                .build();
//        return given().body(mapper.writeValueAsString(testInterestDto)).contentType(APPLICATION_JSON).when()
//                .post(INTERESTS_URL).as(InterestDto.class);
//
//    }
}