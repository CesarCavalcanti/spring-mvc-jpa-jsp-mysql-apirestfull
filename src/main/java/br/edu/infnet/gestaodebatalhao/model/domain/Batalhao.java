package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "batalhao")
public class Batalhao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;
    @Column (name = "nome")
    private String nome;
    @OneToMany
    private List<Oficial> oficiais;
    @OneToMany
    private List<Praca> pracas;
    @OneToMany
    private List<Reserva> reserva;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "endereco_id")
    private Endereco endereco;

    public Batalhao() {
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

    public List<Oficial> getOficiais() {
        return oficiais;
    }

    public void setOficiais(List<Oficial> oficiais) {
        this.oficiais = oficiais;
    }

    public List<Praca> getPracas() {
        return pracas;
    }

    public void setPracas(List<Praca> pracas) {
        this.pracas = pracas;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
