package com.api.acesso.auth.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import com.api.acesso.auth.entity.User;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("Tests for user Repository")
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
    public void getAll() {
        List<User> users = this.repository.findAll();
        Assertions.assertEquals(users.size(), 1);
    }

    @Test
    public void find(){
        String name = this.repository.findRoleByUserId(2l);
        Assertions.assertEquals(name,"jorge");
    }
}