package com.tabless.services;

import com.tabless.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService
{

    UserDetails loadUserByUsername(String username);

    List<User> findAll();

    User findUserByUsername(String username);

    void delete(long id);

    User save(User user);

    User update(User user, long id);
}