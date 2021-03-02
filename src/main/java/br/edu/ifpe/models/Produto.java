package br.edu.ifpe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity(name = "produtos")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull @Column(length = 50)
    private String nome;

    @ManyToOne @NotNull
    private Categoria categoria;

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

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
