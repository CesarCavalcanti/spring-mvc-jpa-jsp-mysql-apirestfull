package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "viatura")
public class Viatura {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;
    @Column (name = "tipo")
    private String tipo;
    @Column (name = "patrimonio")
    private String patrimonio;
    @Column (name = "kilometragem")
    private String kilometragem;

    public Viatura() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(String kilometragem) {
        this.kilometragem = kilometragem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
