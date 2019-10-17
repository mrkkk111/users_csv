package com.cx.users.csv.controllers.users;

import com.cx.users.csv.dao.users.User;
import com.cx.users.csv.services.users.UserDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/all")
    @ResponseBody
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userDaoService.getAllUsers());
    }


}
