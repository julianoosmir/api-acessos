package com.api.acesso;

import com.api.acesso.auth.entity.Role;
import com.api.acesso.auth.entity.User;
import com.api.acesso.auth.service.RoleService;
import com.api.acesso.auth.service.UserService;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Initializer {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

//    @PostConstruct
//    public void criaUsuariosEPermissoes() {
//        Role roleAdmin = new Role();
//
//        roleAdmin.setName("ADMIN");
//
//        roleService.save(roleAdmin);
//
//        User user = new User();
//        user.setAtivo(true);
//        user.setEmail("teste@teste.com");
//        user.setNome("juliano");
//        user.setSenha(new BCryptPasswordEncoder().encode("123456"));
//        user.setUsername("julianoosmir");
//        user.setRoles(Arrays.asList(roleAdmin));
//
//        userService.save(user);
//
//    }
}
