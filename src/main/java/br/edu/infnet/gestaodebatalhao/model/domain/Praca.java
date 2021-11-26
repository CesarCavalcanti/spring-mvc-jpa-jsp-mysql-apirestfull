package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "praca")
@PrimaryKeyJoinColumn(name = "id")
public class Praca extends PolicialMilitar{

    @Column(name = "graduacao")
    private String graduacao;
    @Column (name = "companhia")
    private String companhia;
    @Column (name = "cargo")
    private String cargo;
    @Column (name = "secao")
    private String secao;

    public Praca() {
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }
}
