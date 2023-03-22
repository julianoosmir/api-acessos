package com.api.acesso.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.acesso.auth.entity.Role;
import com.api.acesso.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT role.name FROM role join user_roles on user_roles.roles_id = role.id join user on user_roles.user_id = user.id where user.id = ?1")
    String findRoleByUserId(Long id);

    User findByUsername(String username);

}
