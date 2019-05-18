package model.bean;

import java.sql.Date;

public class Exemplar {
    private int idExemplar;
    private int NumSerie;
    private Date dataEntrada;
    private String conservação;
    private boolean statusExemplar;

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

    public String getConservação() {
        return conservação;
    }

    public void setConservação(String conservação) {
        this.conservação = conservação;
    }

    public boolean isStatusExemplar() {
        return statusExemplar;
    }

    public void setStatusExemplar(boolean statusExemplar) {
        this.statusExemplar = statusExemplar;
    }
}
