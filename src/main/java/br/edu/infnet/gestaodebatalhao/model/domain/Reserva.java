package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "reserva")
public class Reserva extends  PolicialMilitar{

    @Column(name = "idaded")
    private String idade;
    @Column (name = "lotacao")
    private String lotacao;
    @Column (name = "matriculaEspecial")
    private String matriculaEspecial;
    @ManyToOne
    @JoinColumn(name = "idBatalhao")
    private Batalhao batalhao;

    public Reserva() {
    }

    public Batalhao getBatalhao() {
        return batalhao;
    }

    public void setBatalhao(Batalhao batalhao) {
        this.batalhao = batalhao;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public String getMatriculaEspecial() {
        return matriculaEspecial;
    }

    public void setMatriculaEspecial(String matriculaEspecial) {
        this.matriculaEspecial = matriculaEspecial;
    }
}
