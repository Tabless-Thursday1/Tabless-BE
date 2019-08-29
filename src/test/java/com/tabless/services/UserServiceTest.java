package com.tabless.services;

import com.tabless.StartHereApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartHereApplication.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

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
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }
}