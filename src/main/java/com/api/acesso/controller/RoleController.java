package com.api.acesso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.acesso.auth.entity.Role;
import com.api.acesso.auth.service.RoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAll() {
        return roleService.findAll();
    }

    @PostMapping
    public Role saveRole(@RequestBody Role role) {
        return roleService.save(role);
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }

}
