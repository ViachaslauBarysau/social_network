package com.itechart.social_network.service.impl;

import com.itechart.social_network.dto.InterestDto;
import com.itechart.social_network.dto.PairDto;
import com.itechart.social_network.dto.UserDto;
import com.itechart.social_network.service.CalculationService;
import com.itechart.social_network.service.UserService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PairCalculationServiceImpl implements CalculationService {
    private final UserService userService;

    public PairCalculationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<PairDto> getPairs() throws IOException {
        List<UserDto> users = userService.getUsers();
        List<PairDto> pairs = new ArrayList<>();
        List<PairDto> pairsDtoList = new ArrayList<>();
        int connectionStrength = 0;
        findPairs(users, pairs, pairsDtoList, connectionStrength);
        return pairsDtoList;
    }

    private void findPairs(List<UserDto> users, List<PairDto> pairs, List<PairDto> pairsDtoList,
                           int connectionStrength) {
        if (users.size() > 1) {
            for (int i = 0; i < users.size(); i++) {
                for (int j = 1; j < users.size(); j++) {
                    if (!users.get(i).equals(users.get(j))) {
                        List<InterestDto> interests = new ArrayList<>(users.get(i).getInterests());
                        interests.retainAll(users.get(j).getInterests());
                        checkPairForExisting(users, pairs, pairsDtoList, connectionStrength, i, j, interests);
                    }
                }
            }
        } else {
            if (isTheBetterSolution(pairs, pairsDtoList)) {
                pairsDtoList.clear();
                pairsDtoList.addAll(pairs);
            }
        }
    }

    private boolean isTheBetterSolution(List<PairDto> pairs, List<PairDto> pairsDtoList) {
        return pairs.size() > pairsDtoList.size() || pairs.size() == pairsDtoList.size() && pairs.stream()
                .mapToInt(PairDto::getStrengthOfConnection)
                .sum() > pairsDtoList.stream()
                .mapToInt(PairDto::getStrengthOfConnection)
                .sum();
    }

    private void checkPairForExisting(List<UserDto> users, List<PairDto> pairs, List<PairDto> pairsDtoList,
                                      int connectionStrength, int i, int j, List<InterestDto> interests) {
        if (interests.size() > 0) {
            List<UserDto> userList = new ArrayList<>(users);
            userList.remove(users.get(i));
            userList.remove(users.get(j));
            List<PairDto> pairList = new ArrayList<>(pairs);
            pairList.add(PairDto.builder()
                    .firstUser(users.get(i))
                    .secondUser(users.get(j))
                    .interests(interests)
                    .strengthOfConnection(interests.size())
                    .build());
            int totalConnectionStrength = connectionStrength + interests.size();
            findPairs(userList, pairList, pairsDtoList, totalConnectionStrength);
        }
    }
}
