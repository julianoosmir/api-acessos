package com.api.acesso.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Forca {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dica;
    private String palavra;

    public Forca() {
    }

    public Forca(Long id, String dica, String palavra) {
        this.id = id;
        this.dica = dica;
        this.palavra = palavra;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDica() {
        return this.dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public String getPalavra() {
        return this.palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public Forca id(Long id) {
        setId(id);
        return this;
    }

    public Forca dica(String dica) {
        setDica(dica);
        return this;
    }

    public Forca palavra(String palavra) {
        setPalavra(palavra);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Forca)) {
            return false;
        }
        Forca forca = (Forca) o;
        return Objects.equals(id, forca.id) && Objects.equals(dica, forca.dica)
                && Objects.equals(palavra, forca.palavra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dica, palavra);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", dica='" + getDica() + "'" +
                ", palavra='" + getPalavra() + "'" +
                "}";
    }
}
