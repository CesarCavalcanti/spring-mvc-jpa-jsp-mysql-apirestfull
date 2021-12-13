package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "reserva")
@PrimaryKeyJoinColumn(name = "id")
public class Reserva extends  PolicialMilitar{

    @Column(name = "idaded")
    private String idade;
    @Column (name = "lotacao")
    private String lotacao;
    @Column (name = "matriculaEspecial")
    private String matriculaEspecial;
    public Reserva() {
    }

    public Reserva( String nome, String patente, String matricula, String celular, String idade, String lotacao, String matriculaEspecial) {
        super(nome, patente, matricula, celular);
        this.idade = idade;
        this.lotacao = lotacao;
        this.matriculaEspecial = matriculaEspecial;
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
