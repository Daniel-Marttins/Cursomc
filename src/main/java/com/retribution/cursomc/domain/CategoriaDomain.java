package com.retribution.cursomc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class CategoriaDomain implements Serializable {
    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private List<ProdutoDomain> produtos = new ArrayList<>();

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public List<ProdutoDomain> getProdutos() { return produtos;}

    public void setProdutos(List<ProdutoDomain> produtos) { this.produtos = produtos;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaDomain)) return false;
        CategoriaDomain that = (CategoriaDomain) o;
        return getId().equals(that.getId());
    }

}
