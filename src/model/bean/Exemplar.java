package model.bean;

import java.util.Date;

public class Exemplar {
    private int idExemplar;
    private String NumSerie;
    private Date dataEntrada;
    private String conservacao;
    private boolean statusExemplar;
    private Date dataRemocao;
    private Livro livro;
    private boolean status;

    public Exemplar() {
        this.idExemplar = 0;
        this.NumSerie = "";
        this.dataEntrada = null;
        this.conservacao = "";
        this.dataRemocao = null;
        this.statusExemplar = false;
        this.livro = new Livro();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataRemocao()
    {
        return this.dataRemocao;
    }

    public void setDataRemocao(Date dataRemocao)
    {
        this.dataRemocao = dataRemocao;
    }

    public int getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }

    public String getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(String numSerie) {
        this.NumSerie = numSerie;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getConservacao() {
        return conservacao;
    }

    public void setConservacao(String conservacao) {
        this.conservacao = conservacao;
    }

    public boolean isStatusExemplar() {
        return statusExemplar;
    }

    public void setStatusExemplar(boolean statusExemplar) {
        this.statusExemplar = statusExemplar;
    }
}
