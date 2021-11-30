package br.edu.infnet.gestaodebatalhao.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "oficial")
@PrimaryKeyJoinColumn(name = "id")
public class Oficial extends PolicialMilitar{

    @Column (name = "posto")
    private String posto;
    @Column (name = "quadro")
    private String quadro;
    @Column (name = "secao")
    private String secao;
    @Column (name = "companhia")
    private String companhia;
    @Column (name = "funcao")
    private String funcao;
    @ManyToOne
    @JoinColumn(name = "idBatalhao")
    private Batalhao batalhao;
    @ManyToOne
    @JoinColumn (name = "idUsuario")
    private Usuario usuario;


    public Oficial() {
    }

    public Batalhao getBatalhao() {
        return batalhao;
    }

    public void setBatalhao(Batalhao batalhao) {
        this.batalhao = batalhao;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
