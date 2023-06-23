package com.api.acesso.auth.repository;

import java.util.Arrays;
import java.util.List;

import com.api.acesso.AcessoApplication;
import com.api.acesso.AcessoApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import com.api.acesso.auth.entity.User;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("Tests for user Repository")
@AutoConfigureTestDatabase
@ExtendWith(SpringExtension.class)
@Profile("test")
@ActiveProfiles("test")
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    @Qualifier("userRepository")
    private UserRepository repository;

    @BeforeEach
    private void setUp() {

    }

    @Test
    public void save() {
        List<User> users = this.repository.findAll();
        Assertions.assertEquals(users.size(), 2);
    }

}
