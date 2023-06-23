package com.api.acesso.auth.controller;

import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.api.acesso.auth.service.UserService;
import com.api.acesso.config.jwt.JwtRequest;
import com.api.acesso.dto.AuthDto;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Assertions;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@Profile("test")
public class AuthControllerTest {

    @Mock
    private UserService userService;
    @InjectMocks
    private AuthController authController;

    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
        RestAssured.port = port;

    }

    @Test
    public void devefazerAuthenticacaoComJWT() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("julianoosmir");
        jwtRequest.setSenha("123456");

        AuthDto auth = given().log().all()
                .body(jwtRequest)
                .contentType(ContentType.JSON)
                .when()
                .post("/auth/signin")
                .then()
                .log().all()
                .statusCode(200)
                .body("role",Matchers.is("ADMIN"))
                .body("sign", Matchers.is(true))
                .extract().body().as(AuthDto.class);

        Assertions.assertEquals(auth.getRole(), "ADMIN");
        Assertions.assertEquals(auth.getSign(), true);

    }
}
