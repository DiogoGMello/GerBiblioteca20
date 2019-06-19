package model.bean;

import java.util.Date;

public class Exemplar {
    private int idExemplar;
    private int NumSerie;
    private Date dataEntrada;
    private String conservacao;
    private boolean statusExemplar;
    private Livro livro;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Exemplar(){
    }

    public int getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }

    public int getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(int numSerie) {
        NumSerie = numSerie;
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
