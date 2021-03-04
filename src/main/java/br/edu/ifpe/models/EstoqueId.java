package br.edu.ifpe.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;


@Embeddable
public class EstoqueId  implements Serializable {
    private static final long serialVersionUID = 5114770736427051887L;
    
    @Column(name = "lote") @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer lote;

    @Column(name = "produto_id")
    private Integer produto;

    public EstoqueId() {}

    public EstoqueId(Integer lote, Integer produto) {
        this.lote = lote;
        this.produto = produto;
    }

    public Integer getLote() { return lote; }
    public void setLote(Integer lote) { this.lote = lote; }

    public Integer getProduto() { return produto; }
    public void setProduto(Integer produto) { this.produto = produto; }
}
