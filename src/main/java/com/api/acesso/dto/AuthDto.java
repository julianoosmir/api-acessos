package com.api.acesso.dto;


import java.util.Objects;

public class AuthDto {
    private String role;
    private boolean sign;
    private String token;

    public AuthDto() {
    }

    public AuthDto(String role, boolean sign, String token) {
        this.role = role;
        this.sign = sign;
        this.token = token;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isSign() {
        return this.sign;
    }

    public boolean getSign() {
        return this.sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthDto role(String role) {
        setRole(role);
        return this;
    }

    public AuthDto sign(boolean sign) {
        setSign(sign);
        return this;
    }

    public AuthDto token(String token) {
        setToken(token);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AuthDto)) {
            return false;
        }
        AuthDto authDto = (AuthDto) o;
        return Objects.equals(role, authDto.role) && sign == authDto.sign && Objects.equals(token, authDto.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, sign, token);
    }

    @Override
    public String toString() {
        return "{" +
                " role='" + getRole() + "'" +
                ", sign='" + isSign() + "'" +
                ", token='" + getToken() + "'" +
                "}";
    }

}
