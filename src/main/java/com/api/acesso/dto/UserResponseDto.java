package com.api.acesso.dto;

public class UserResponseDto {

    private Long id;
    private String nome;
    private String username;
    private String perfil;

    public UserResponseDto(Long id, String nome, String username, String perfil) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPerfil() {
        return perfil;  
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
}
