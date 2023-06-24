package com.api.acesso.auth.service;

import com.api.acesso.auth.entity.Role;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.acesso.auth.entity.User;
import com.api.acesso.auth.repository.UserRepository;
import com.api.acesso.config.ModalMapperConfig;
import com.api.acesso.config.jwt.JwtRequest;
import com.api.acesso.config.jwt.JwtTokenUtil;
import com.api.acesso.dto.AuthDto;
import com.api.acesso.dto.UserDto;
import com.api.acesso.dto.UserResponseDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public User salvar(UserDto userdto) {
        userdto.setSenha(this.enconderPassword(userdto.getSenha()));
        User user = this.mapper.map(userdto, User.class);
        Role role = roleService.findById(userdto.getPerfil());
        user.setRoles(role);
        return repository.save(user);
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public List<UserResponseDto> findAllDtos() {
        List<UserResponseDto> userdtos = new ArrayList<>();
        this.findAll().forEach(user -> {
            UserResponseDto dto = new UserResponseDto(user.getId(), user.getNome(), user.getUsername(),
                    user.getRoles().getName());
            userdtos.add(dto);
        });
        return userdtos;
    };

    private String getNamesRoles(List<Role> roles) {
        List<String> nomesRoles = roles.stream().map(Role::getName).collect(Collectors.toList());
        return nomesRoles.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    private String enconderPassword(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }

    private String getRoleName(Long id) {
        Role role = findById(id).getRoles();
        return role.getName();
    }

    public ResponseEntity<?> signin(JwtRequest authenticationRequest) {

        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getSenha());

            final User userDetails = repository.findByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);

           final AuthDto authDto = new AuthDto(getRoleName(userDetails.getId()), true, token);

            return ResponseEntity.ok(authDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USUARIO DESABILITADO", e);
        } catch (BadCredentialsException e) {
            throw new Exception("CREDENCIAIS INVALIDAS", e);
        } catch (InternalAuthenticationServiceException e) {
            throw new Exception("USUARIO NÃO CADASTRADO", e);
        }
    }
}
