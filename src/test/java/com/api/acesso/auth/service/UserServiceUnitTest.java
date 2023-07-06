package com.api.acesso.auth.service;

import com.api.acesso.auth.entity.User;
import com.api.acesso.auth.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceUnitTest {
   @Mock
   private UserRepository userRepository;
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

}
