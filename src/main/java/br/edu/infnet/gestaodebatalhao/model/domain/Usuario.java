package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "admin")
    private Boolean admin;
    @OneToMany (cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
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

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
