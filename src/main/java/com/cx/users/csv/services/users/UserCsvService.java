package com.cx.users.csv.services.users;

import com.cx.users.csv.dao.users.User;
import com.cx.users.csv.utils.csv.users.CsvUsersParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserCsvService {

    private Logger logger = LoggerFactory.getLogger(UserCsvService.class);

    public List<User> parseCsvFile(Reader reader) throws IOException {
        CsvUsersParser csvFileParser = csvFileUtilFactory(reader);
        List<User> users = getUsers(csvFileParser);
        return users;
    }

    private List<User> getUsers(CsvUsersParser csvFileParser) {
        List<User> users = new ArrayList<>();

        User user = null;
        while (csvFileParser.hasNext()) {
            try {
                user = csvFileParser.process();
                users.add(user);
            } catch (ConstraintViolationException cve) {
                logger.error(cve.getMessage());
            }
        }
        return users;
    }

    protected CsvUsersParser csvFileUtilFactory(Reader reader) throws IOException {
        return new CsvUsersParser(reader);
    }

}
