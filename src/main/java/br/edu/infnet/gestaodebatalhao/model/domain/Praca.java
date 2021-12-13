package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "praca")
@PrimaryKeyJoinColumn(name = "id")
public class Praca extends PolicialMilitar{

    @Column (name = "secao")
    private String secao;
    @Column (name = "companhia")
    private String companhia;
    @Column (name = "cargo")
    private String cargo;

    public Praca() {
    }

    public Praca(String nome, String patente, String matricula, String celular, String secao, String companhia, String cargo) {
        super( nome, patente, matricula, celular);
        this.secao = secao;
        this.companhia = companhia;
        this.cargo = cargo;
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
