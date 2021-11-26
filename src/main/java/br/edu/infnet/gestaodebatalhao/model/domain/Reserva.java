package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva extends  PolicialMilitar{

    @Column(name = "idaded")
    private String idade;
    @Column (name = "lotacao")
    private String lotacao;
    @Column (name = "matriculaEspecial")
    private String matriculaEspecial;

    public Reserva() {
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
