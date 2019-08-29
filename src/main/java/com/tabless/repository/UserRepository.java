package com.tabless.repository;

import com.tabless.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);

    User findById(long id);
}
