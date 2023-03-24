package com.api.acesso.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.acesso.auth.entity.Role;
import com.api.acesso.auth.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public Role save(Role role) {
        return repository.save(role);
    }

    public Role saveRole(String roleName) {
        Role role = new Role();
        role.setName(roleName);
        return repository.save(role);
    }

    public Role findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Role> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
