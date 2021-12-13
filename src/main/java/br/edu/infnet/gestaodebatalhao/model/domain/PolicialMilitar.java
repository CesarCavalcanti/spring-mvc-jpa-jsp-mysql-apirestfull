package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;

@Entity
@Table (name="policialMilitar")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PolicialMilitar {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "patente")
    private String patente;
    @Column (name = "matricula", unique = true)
    private String matricula;
    @Column (name = "celular")
    private String celular;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "idEndereco")
    private Endereco endereco;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idBatalhao")
    private Batalhao batalhao;
    public PolicialMilitar() {
    }

    public PolicialMilitar( String nome, String patente, String matricula, String celular) {

        this.nome = nome;
        this.patente = patente;
        this.matricula = matricula;
        this.celular = celular;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String posto) {
        this.patente = posto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Batalhao getBatalhao() {
        return batalhao;
    }

    public void setBatalhao(Batalhao batalhao) {
        this.batalhao = batalhao;
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
