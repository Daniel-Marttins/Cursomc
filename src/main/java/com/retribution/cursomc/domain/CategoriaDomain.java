package com.retribution.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

public class CategoriaDomain implements Serializable {
    private  static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public CategoriaDomain(){}

    public CategoriaDomain(Integer id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomee) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaDomain)) return false;
        CategoriaDomain that = (CategoriaDomain) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
