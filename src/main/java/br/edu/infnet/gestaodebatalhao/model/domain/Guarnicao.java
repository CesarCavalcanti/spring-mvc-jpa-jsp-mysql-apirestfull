package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "guarnicao")
public class Guarnicao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idViatura")
    private Viatura viatura;
    @ManyToOne
    @JoinColumn(name = "idOficial")
    private Oficial oficial;
    @ManyToOne
    @JoinColumn(name = "idPraca")
    private Praca praca;
    @Column(name = "area")
    private String area;
    @Column(name = "turno")
    private String turno;
    @Column(name = "identificacao")
    private String identificacao;

    public Guarnicao() {
    }

    public Viatura getViatura() {
        return viatura;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }

    public Oficial getOficial() {
        return oficial;
    }

    public void setOficial(Oficial oficial) {
        this.oficial = oficial;
    }

    public Praca getPraca() {
        return praca;
    }

    public void setPraca(Praca praca) {
        this.praca = praca;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
