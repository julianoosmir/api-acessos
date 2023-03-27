package com.api.acesso.repository;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.acesso.auth.entity.Role;
import com.api.acesso.auth.entity.User;
import com.api.acesso.auth.repository.RoleRepository;
import com.api.acesso.auth.repository.UserRepository;

@DisplayName("Tests for user Repository")
@AutoConfigureTestDatabase
@DataJpaTest
public class UserRpositoryTest {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;

    private Role roleAdmin;

    private User user;

    @BeforeEach
    private void setUp() {
        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        this.roleAdmin = this.roleRepository.save(roleAdmin);
    }

    @Test
    public void save() {
        User user = new User();
        user.setAtivo(true);
        user.setEmail("teste@teste.com");
        user.setNome("juliano");
        user.setSenha(new BCryptPasswordEncoder().encode("123456"));
        user.setUsername("julianoosmir");
        user.setRoles(Arrays.asList(this.roleAdmin));

        this.user = this.repository.save(user);
        Assertions.assertNotNull(this.user);
    }

}
