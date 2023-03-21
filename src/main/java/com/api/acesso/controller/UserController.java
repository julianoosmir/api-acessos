package com.api.acesso.controller;

import com.api.acesso.auth.entity.User;
import com.api.acesso.auth.service.UserService;
import com.api.acesso.dto.UserDto;
import com.api.acesso.dto.UserResponseDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> testGet() {
        return this.userService.findAll();
    }

    @GetMapping("/todos")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserResponseDto> dtoGet() {
        return this.userService.findAllDtos();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public User testPost(@RequestBody UserDto userdto) {
        return this.userService.salvar(userdto);
    }

    @DeleteMapping
    public String testDelete() {
        return "testando delete user";
    }

}
