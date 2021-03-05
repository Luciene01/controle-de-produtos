package br.edu.ifpe.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity(name = "usuarios")
public class Usuario {

    @Id @GeneratedValue
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @NotBlank @Enumerated(EnumType.STRING)
    private Cargo cargo;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) {this.cargo = cargo; }

}
