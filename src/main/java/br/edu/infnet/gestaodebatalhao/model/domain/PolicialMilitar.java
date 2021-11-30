package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;

@Entity
@Table (name="policialMilitar")
@Inheritance(strategy = InheritanceType.JOINED)
public class PolicialMilitar {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "matricula")
    private String matricula;
    @Column (name = "celular")
    private String celular;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "idEndereco")
    private Endereco endereco;

    public PolicialMilitar() {
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
