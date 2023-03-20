package com.api.acesso.dto;

public class UserDto {
    private String nome;

    private String username;

    private String email;

    private String senha;

    private Boolean ativo;  
    
    private String perfil;

    public UserDto(String nome, String username, String email, String senha, Boolean ativo, String perfil) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    
    
    
    
}
