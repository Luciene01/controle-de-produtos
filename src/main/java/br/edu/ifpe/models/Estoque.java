package br.edu.ifpe.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity
public class Estoque {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne @NotNull
    private Produto produto;

    @NotNull
    private Integer quantidadeComprada;

    @NotNull
    private Integer quantidadeConsumida;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataValidade;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidadeComprada() {
        return quantidadeComprada;
    }
    public void setQuantidadeComprada(Integer quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public Integer getQuantidadeConsumida() {
        return quantidadeConsumida;
    }
    public void setQuantidadeConsumida(Integer quantidadeConsumida) {
        this.quantidadeConsumida = quantidadeConsumida;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

}