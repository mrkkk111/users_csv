package com.cx.users.csv.services.users;

import com.cx.users.csv.dao.users.User;
import com.cx.users.csv.repos.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

/*    @PostConstruct
    public void createTestUsers(){
        userRepository.save(new User("Markowski", "Adam", LocalDate.of(1982, 11, 14), "666123321"));
        userRepository.save(new User("Kowalski", "Zenon", LocalDate.of(1992, 2, 17), "555123321"));

    }*/

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
