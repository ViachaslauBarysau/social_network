package com.itechart.social_network.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PairDto {
    private UserDto firstUser;
    private UserDto secondUser;
    private List<InterestDto> interests = new ArrayList<>();
    private int strengthOfConnection;
}
