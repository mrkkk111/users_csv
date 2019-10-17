package com.cx.users.csv.controllers.users;

import com.cx.users.csv.dao.users.User;
import com.cx.users.csv.services.users.UserDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userDaoService.getAllUsers());
    }

    // JSR validation annotations don't seem to work on the method below
    @GetMapping("/byname/{name:.{3," + User.MAX_STR_FIELD_LENGTH + "}}")
    public ResponseEntity<List<User>> getUsersByName(@PathVariable("name") String userName) {
        return ResponseEntity.ok(userDaoService.getUsersByLastNameSortedByBirthDate(userName));
    }

    @GetMapping("/oldest")
    public ResponseEntity<List<User>> getOldestUserWithPhoneNumber() {
        return ResponseEntity.ok(userDaoService.getOldestUserWithPhoneNumber());
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getUserCount() {
        return ResponseEntity.ok(userDaoService.getUserCount());
    }


}
