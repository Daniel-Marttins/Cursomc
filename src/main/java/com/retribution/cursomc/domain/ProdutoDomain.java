package com.retribution.cursomc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Cria uma entidade(tabela)no banco de dados local
//Serializible, e uma interface que transforma os objetos em bits para serem enviados para um determinado local
@Entity
public class ProdutoDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    //Define os campos que serão os id ou seja as chaves primarias da tabela
    //Generate, gera os valores dos ids automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private double preco;

    //ManyToMany faz uma tabela se juntar uma ao lado da outra usando suas chaves primarias como chaves estrangeiras criando uma nova tabela
    //JoinTable, une duas tabelas e abaixo podemos ver como dar nome a tabela, e pegar as chaves primarias das tabelas que originou essa nova tabela
    @ManyToMany
    @JoinTable(
            name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )

    //Cria uma lista e categorias que já está iniciada
    private List<CategoriaDomain> categorias = new ArrayList<>();

    //Construtor vazio, usado para instanciar os metodos privados em outras classes
    public ProdutoDomain(){}

    public ProdutoDomain(Integer id, String nome, double preco) {
        super();
        this.id = id;
        this.nome = nome;
        this.preco = preco;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<CategoriaDomain> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaDomain> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdutoDomain that = (ProdutoDomain) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
