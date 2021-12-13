package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "oficial")
@PrimaryKeyJoinColumn(name = "id")
public class Oficial extends PolicialMilitar{

    @Column (name = "quadro")
    private String quadro;
    @Column (name = "secao")
    private String secao;
    @Column (name = "companhia")
    private String companhia;
    @Column (name = "funcao")
    private String funcao;

    public Oficial() {
    }

    public Oficial(String nome, String patente, String matricula, String celular, String quadro, String secao, String companhia, String funcao) {
        super(nome, patente, matricula, celular);
        this.quadro = quadro;
        this.secao = secao;
        this.companhia = companhia;
        this.funcao = funcao;
    }

    public String getQuadro() {
        return quadro;
    }

    public void setQuadro(String quadro) {
        this.quadro = quadro;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }


}
