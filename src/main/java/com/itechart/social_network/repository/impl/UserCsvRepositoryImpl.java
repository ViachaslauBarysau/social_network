package com.itechart.social_network.repository.impl;

import com.itechart.social_network.entity.Interest;
import com.itechart.social_network.entity.User;
import com.itechart.social_network.repository.UserRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

import static com.itechart.social_network.constant.Constants.*;

@Repository
@ConditionalOnProperty(prefix = REPOSITORY, name = IMPLEMENTATION, havingValue = CSV)
public class UserCsvRepositoryImpl implements UserRepository {

    @Override
    public List<User> findAll() throws IOException {
        return readUsersFromFile();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(User user) {
    }

    private List<User> readUsersFromFile() throws IOException {
        List<User> users = new ArrayList<>();
        Map<Long, Interest> interestsMap = parseInterestsFile();
        String[] HEADERS = {ID, NAME, INTEREST_ID};
        File file = ResourceUtils.getFile(CLASSPATH + DOUBLE_DOT + USERS + DOT + CSV);
        Reader in = new FileReader(file);
        Iterable<CSVRecord> records = CSVFormat.newFormat((DOT_COMA_DELIMITER).charAt(0))
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);
        getUserList(users, interestsMap, records);
        return users;
    }

    private void getUserList(List<User> users, Map<Long, Interest> interestsMap, Iterable<CSVRecord> records) {
        for (CSVRecord record : records) {
            List<Interest> interests = getInterestList(interestsMap, record);
            users.add(User.builder()
                    .id(Long.parseLong(record.get(ID)))
                    .name(record.get(NAME))
                    .interests(interests)
                    .build());
        }
    }

    private List<Interest> getInterestList(Map<Long, Interest> interestsMap, CSVRecord record) {
        List<Long> interestsIdList = Arrays.stream(record.get(INTEREST_ID)
                .split(COMA_DELIMITER))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        List<Interest> interests = new ArrayList<>();
        for (Long id : interestsIdList) {
            interests.add(interestsMap.get(id));
        }
        return interests;
    }

    private HashMap<Long, Interest> parseInterestsFile() throws IOException {
        HashMap<Long, Interest> interests = new HashMap<>();
        String[] HEADERS = {ID, NAME};
        File file = ResourceUtils.getFile(CLASSPATH + DOUBLE_DOT + INTERESTS + DOT + CSV);
        Reader in = new FileReader(file);
        Iterable<CSVRecord> records = CSVFormat.newFormat((DOT_COMA_DELIMITER).charAt(0))
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            interests.put(Long.parseLong(record.get(ID)), Interest.builder()
                    .id(Long.parseLong(record.get(ID)))
                    .name(record.get(NAME))
                    .build());
        }
        return interests;
    }
}
