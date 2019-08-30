package com.tabless.services;

import com.tabless.StartHereApplication;
import com.tabless.models.Role;
import com.tabless.models.User;
import com.tabless.models.UserRoles;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartHereApplication.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired RoleService roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void loadUserByUsername() {
        //Not tested because not actively utilized.
    }

    @Test
    void findAll() {
        assertEquals(2, userService.findAll().size());
    }

    @Test
    void findUserByUsername() {
        assertEquals("admin", userService.findUserByUsername("admin").getUsername());
    }

    @Test
    void delete() {
        assertNotNull(userService.findUserByUsername("admin"));
        userService.delete(4);
        assertNull(userService.findUserByUsername("admin"));
    }

    @Test
    void save() {
        ArrayList<UserRoles> test = new ArrayList<>();
        User testUser = new User("Test", "User", "testuser", "testpass", test);
        assertNull(userService.findUserByUsername("testuser"));
        userService.save(testUser);
        assertNotNull(userService.findUserByUsername("testuser"));
    }

    @Test
    void update() {
        //No test, as I don't know how to implement authentication within a JUnit Test.
    }
}