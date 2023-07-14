package com.api.acesso.auth.service;

import com.api.acesso.auth.entity.User;
import com.api.acesso.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@DisplayName("Tests for user service")
@ExtendWith(SpringExtension.class)
@Profile("test")
@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {

   @Autowired
   @Qualifier("userService")
   private UserService userService;

   @BeforeEach
   private void setUp() {

   }
   @Test
   public void getAll(){
      List<User> users = this.userService.findAll();
      Assertions.assertEquals(users.size(),1);
   }
   @Test
   public void salvar(){
      User user = new User();
      UserDto dto = new UserDto();
      dto.setSenha("123456");
      dto.setUsername("lulu");
      dto.setPerfil(1L);
      dto.setEmail("teste@teste");
      dto.setNome("teste");
      User userSalvo = userService.salvar(dto);
      Assertions.assertEquals(userSalvo.getNome(),"teste");
   }
}
