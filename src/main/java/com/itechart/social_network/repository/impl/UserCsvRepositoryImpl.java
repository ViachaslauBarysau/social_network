package com.itechart.social_network.repository.impl;

import com.itechart.social_network.entity.Interest;
import com.itechart.social_network.entity.User;
import com.itechart.social_network.repository.UserRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@ConditionalOnProperty(prefix = "repository", name = "implementation", havingValue = "csv")
public class UserCsvRepositoryImpl implements UserRepository {

    @Override
    public List<User> findAll() throws IOException {
        return parseUsersFile();
    }

    private List<User> parseUsersFile() throws IOException {
        List<User> users = new ArrayList<>();
        HashMap<Long, Interest> interestsMap = parseInterestsFile();
        String[] HEADERS = {"id", "name", "interest_id"};
        File file = ResourceUtils.getFile("classpath:users.csv");
        Reader in = new FileReader(file);
        Iterable<CSVRecord> records = CSVFormat.newFormat((";").charAt(0))
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            List<Long> interestsIdList = Arrays.stream(record.get("interest_id")
                    .split(","))
                    .map(Long::valueOf)
                    .collect(Collectors.toList());
            List<Interest> interests = new ArrayList<>();
            for (Long id : interestsIdList) {
                interests.add(interestsMap.get(id));
            }
            users.add(User.builder()
                          .id(Long.parseLong(record.get("id")))
                          .name(record.get("name"))
                          .interests(interests)
                          .build());
        }
        return users;
    }

    private HashMap<Long, Interest> parseInterestsFile() throws IOException {
        HashMap<Long, Interest> interests = new HashMap<>();
        String[] HEADERS = {"id", "name"};
        File file = ResourceUtils.getFile("classpath:interests.csv");
        Reader in = new FileReader(file);
        Iterable<CSVRecord> records = CSVFormat.newFormat((";").charAt(0))
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            interests.put(Long.parseLong(record.get("id")), Interest.builder()
                                                                    .id(Long.parseLong(record.get("id")))
                                                                    .name(record.get("name"))
                                                                    .build());
        }
        return interests;
    }
}
