package br.edu.ifpe.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity(name = "users")
public class User {

    @Id @GeneratedValue
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String cep;

    @NotBlank @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @NotBlank @ManyToOne
    private Categoria categorias;

    @NotBlank @ManyToOne
    private Produto produtos;

    @NotBlank @ManyToOne
    private Estoque estoques;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }


    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getCep() { return cep;}
    public void setCep(String cep) { this.cep = cep; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) {this.cargo = cargo; }

    public Categoria getCategorias() { return categorias; }

    public Produto getProdutos() { return produtos; }
    public void setProdutos(Produto produtos) { this.produtos = produtos; }

    public Estoque getEstoques() { return estoques; }
    public void setEstoques(Estoque estoques) { this.estoques = estoques; }

}
