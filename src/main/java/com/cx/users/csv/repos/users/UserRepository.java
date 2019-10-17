package com.cx.users.csv.repos.users;

import com.cx.users.csv.dao.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByPhoneNumber(String phoneNumber);
}
