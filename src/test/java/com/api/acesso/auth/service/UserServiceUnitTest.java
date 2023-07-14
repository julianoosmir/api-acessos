package com.api.acesso.auth.service;

import com.api.acesso.auth.entity.User;
import com.api.acesso.auth.repository.UserRepository;
import com.api.acesso.config.jwt.JwtRequest;
import com.api.acesso.config.jwt.JwtTokenUtil;
import com.api.acesso.dto.AuthDto;
import com.api.acesso.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceUnitTest {
   @Mock
   private UserRepository userRepository;
   @Mock
   private ModelMapper mapper;
   @Mock
   private RoleService roleService;
   @Mock
   private JwtTokenUtil jwtTokenUtil;
   @Mock
   public AuthenticationManager authenticationManager;
   @InjectMocks
   private UserService userService;
   @Test
   public void getAll(){
      List<User> users = new ArrayList<>();
      when(userService.findAll()).thenReturn(users);
      List<User> result = this.userService.findAll();
      Assertions.assertEquals(users, result);
   }
   @Test
   public void update(){
      User user = new User();
      when(userService.save(user)).thenReturn(user);
      User userSalvo = userService.save(user);
      Assertions.assertEquals(user, userSalvo);
   }
   @Test
   public void salvar(){
      UserDto dto = new UserDto();
      User user = new User();
      dto.setSenha("123456");
      dto.setUsername("123456");
      when(this.mapper.map(dto,User.class)).thenReturn(user);
      User usuario = userService.salvar(dto);
      verify(this.userRepository,times(1)).save(user);

   }
   @Test
   public void findbyid(){
      User user = new User();
      user.setId(1L);
      when(userRepository.findById(1L)).thenReturn(Optional.of(user));
      User userSalvo = userService.findById(1L);
      Assertions.assertEquals(user, userSalvo);
   }
   @Test
   public void signin() throws Exception {
      JwtRequest jwtRequest = new JwtRequest();
      jwtRequest.setUsername("julianoosmir");
      jwtRequest.setSenha("123456");
      User user = new User();
      user.setUsername(jwtRequest.getUsername());

      when(userRepository.findByUsername(jwtRequest.getUsername())).thenReturn(user);
      when(jwtTokenUtil.generateToken(user)).thenReturn("token");

      ResponseEntity responseEntity = userService.signin(jwtRequest);

      Assertions.assertNotNull(responseEntity);

   }

   @Test
   public void delete(){
      this.userService.delete(1L);
      verify(this.userRepository,times(1)).deleteById(1L);
   }
}
