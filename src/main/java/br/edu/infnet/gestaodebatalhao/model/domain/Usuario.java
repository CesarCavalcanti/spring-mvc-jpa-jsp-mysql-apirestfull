package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    @OneToMany (cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn (name = "idUsuario")
    private List<PolicialMilitar> policiais;

    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<PolicialMilitar> getPoliciais() {
        return policiais;
    }

    public void setPoliciais(List<PolicialMilitar> policiais) {
        this.policiais = policiais;
    }
}
