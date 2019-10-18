package com.cx.users.csv.controllers.users;

import com.cx.users.csv.dao.users.User;
import com.cx.users.csv.services.users.UserDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/users")
public class UserController {

    private static final Sort USER_PAGE_SORT_ORDER = Sort.by(User.BIRTHDAY_COLUMN_NAME).and(Sort.by(User.ID_COLUMN_NAME));

    @Autowired
    private UserDaoService userDaoService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer pageSize) {
        return ResponseEntity.ok(userDaoService.getAllUsers(PageRequest.of(page, pageSize, USER_PAGE_SORT_ORDER)));
    }

    // JSR validation annotations don't seem to work on the method below
    @GetMapping("/byname/{name:.{3," + User.MAX_STR_FIELD_LENGTH + "}}")
    public ResponseEntity<List<User>> getUsersByName(@PathVariable("name") String userName, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer pageSize) {
        return ResponseEntity.ok(userDaoService.getUsersByLastNameSortedByBirthDate(userName, PageRequest.of(page, pageSize, USER_PAGE_SORT_ORDER)));
    }

    @GetMapping("/oldest")
    public ResponseEntity<List<User>> getOldestUserWithPhoneNumber() {
        return ResponseEntity.ok(userDaoService.getOldestUserWithPhoneNumber());
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getUserCount() {
        return ResponseEntity.ok(userDaoService.getUserCount());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userDaoService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
