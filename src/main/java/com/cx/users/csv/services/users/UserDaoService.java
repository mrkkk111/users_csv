package com.cx.users.csv.services.users;

import com.cx.users.csv.dao.users.User;
import com.cx.users.csv.repos.users.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserDaoService {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserDaoService.class);

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void mergeUsers(Collection<User> users) {
        for (User user : users) {
            List<User> existingUsers = userRepository.findByPhoneNumber(user.getPhoneNumber());
            if (existingUsers.isEmpty() || user.getPhoneNumber() == null) {
                userRepository.save(user);
            } else {
                logger.warn(user.toString() + " already stored");
            }
        }
    }

}
