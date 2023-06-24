package com.api.acesso.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long Id;

    private String nome;

    private String username;

    private String email;

    private String senha;

    private Boolean ativo;

    private Long perfil;

    public Boolean isAtivo() {
        return this.ativo;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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

}
