package br.edu.ifpe.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity(name = "estoques")
public class Estoque {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer lote;

    @ManyToOne @NotNull
    private Produto produto;

    @NotNull
    private Integer quantidadeComprada;

    @NotNull
    private Integer quantidadeVendida;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataValidade;

    public Integer getLote() { return lote; }
    public void setlote(Integer lote) { this.lote = lote; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Integer getQuantidadeComprada() { return quantidadeComprada; }
    public void setQuantidadeComprada(Integer quantidadeComprada) { this.quantidadeComprada = quantidadeComprada; }

    public Integer getQuantidadeVendida() { return quantidadeVendida; }
    public void setQuantidadeVendida(Integer quantidadeVendida) { this.quantidadeVendida = quantidadeVendida; }

    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }

}
