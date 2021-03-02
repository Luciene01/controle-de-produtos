package br.edu.ifpe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;


@Entity(name = "categorias")
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull @Column(length = 50)
    private String nome;

    private boolean perecivel;
    private boolean congelado;

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

    public boolean getPerecivel() {
        return perecivel;
    }
    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }

    public boolean getCongelado() {
        return congelado;
    }
    public void setCongelado(boolean congelado) {
        this.congelado = congelado;
    }
}