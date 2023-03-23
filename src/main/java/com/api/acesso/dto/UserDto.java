package com.api.acesso.dto;

import java.util.Objects;

public class UserDto {

    private Long Id;

    private String nome;

    private String username;

    private String email;

    private String senha;

    private Boolean ativo;

    private String perfil;

    public UserDto() {
    }

    public UserDto(Long Id, String nome, String username, String email, String senha, Boolean ativo, String perfil) {
        this.Id = Id;
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.perfil = perfil;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isAtivo() {
        return this.ativo;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPerfil() {
        return this.perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public UserDto Id(Long Id) {
        setId(Id);
        return this;
    }

    public UserDto nome(String nome) {
        setNome(nome);
        return this;
    }

    public UserDto username(String username) {
        setUsername(username);
        return this;
    }

    public UserDto email(String email) {
        setEmail(email);
        return this;
    }

    public UserDto senha(String senha) {
        setSenha(senha);
        return this;
    }

    public UserDto ativo(Boolean ativo) {
        setAtivo(ativo);
        return this;
    }

    public UserDto perfil(String perfil) {
        setPerfil(perfil);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDto)) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(Id, userDto.Id) && Objects.equals(nome, userDto.nome)
                && Objects.equals(username, userDto.username) && Objects.equals(email, userDto.email)
                && Objects.equals(senha, userDto.senha) && Objects.equals(ativo, userDto.ativo)
                && Objects.equals(perfil, userDto.perfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nome, username, email, senha, ativo, perfil);
    }

    @Override
    public String toString() {
        return "{" +
                " Id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", username='" + getUsername() + "'" +
                ", email='" + getEmail() + "'" +
                ", senha='" + getSenha() + "'" +
                ", ativo='" + isAtivo() + "'" +
                ", perfil='" + getPerfil() + "'" +
                "}";
    }

}
