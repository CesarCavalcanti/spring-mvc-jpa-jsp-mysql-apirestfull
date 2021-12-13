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
    @Column (name = "area", unique = true)
    private String area;
    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idBatalhao")
    private List<PolicialMilitar> policiais;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "endereco_id")
    private Endereco endereco;

    public Batalhao() {
    }

    public Batalhao( String nome, String area) {

        this.nome = nome;
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public List<PolicialMilitar> getPoliciais() {
        return policiais;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setPoliciais(List<PolicialMilitar> policiais) {
        this.policiais = policiais;
    }
}
