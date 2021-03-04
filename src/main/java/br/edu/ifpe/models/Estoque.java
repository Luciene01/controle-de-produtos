package br.edu.ifpe.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity(name = "estoques")
public class Estoque {

    @EmbeddedId 
    private EstoqueId id;

    @ManyToOne(cascade = CascadeType.REMOVE) @NotNull
    @JoinColumn(name = "produto_FK")
    private Produto produto;

    @NotNull
    private Integer quantidadeComprada;

    @NotNull
    private Integer quantidadeVendida;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataValidade;

    public EstoqueId getId() { return id; }
    public void setId(EstoqueId id) { this.id = id; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Integer getQuantidadeComprada() { return quantidadeComprada; }
    public void setQuantidadeComprada(Integer quantidadeComprada) { this.quantidadeComprada = quantidadeComprada; }

    public Integer getQuantidadeVendida() { return quantidadeVendida; }
    public void setQuantidadeVendida(Integer quantidadeVendida) { this.quantidadeVendida = quantidadeVendida; }

    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }

}
