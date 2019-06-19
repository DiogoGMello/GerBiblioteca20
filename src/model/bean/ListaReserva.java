package model.bean;

import java.sql.Date;

public class ListaReserva {

    private int idReserva;
    private int clienteID;
    private int primeiroLivroID;
    private int primeiroExemplarID;
    private int segundoLivroID;
    private int segundoExemplarID;
    private Date dtReservaDoLivro;
    private int emprestimoID;
    private Date dataLimiteReserva;
    private char statusReserva;

    public ListaReserva(){
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getPrimeiroLivroID() {
        return primeiroLivroID;
    }

    public void setPrimeiroLivroID(int primeiroLivroID) {
        this.primeiroLivroID = primeiroLivroID;
    }

    public int getPrimeiroExemplarID() {
        return primeiroExemplarID;
    }

    public void setPrimeiroExemplarID(int primeiroExemplarID) {
        this.primeiroExemplarID = primeiroExemplarID;
    }

    public int getSegundoLivroID() {
        return segundoLivroID;
    }

    public void setSegundoLivroID(int segundoLivroID) {
        this.segundoLivroID = segundoLivroID;
    }

    public int getSegundoExemplarID() {
        return segundoExemplarID;
    }

    public void setSegundoExemplarID(int segundoExemplarID) {
        this.segundoExemplarID = segundoExemplarID;
    }

    public Date getDtReservaDoLivro() {
        return dtReservaDoLivro;
    }

    public void setDtReservaDoLivro(Date dtReservaDoLivro) {
        this.dtReservaDoLivro = dtReservaDoLivro;
    }

    public int getEmprestimoID() {
        return emprestimoID;
    }

    public void setEmprestimoID(int emprestimoID) {
        this.emprestimoID = emprestimoID;
    }

    public Date getDataLimiteReserva() {
        return dataLimiteReserva;
    }

    public void setDataLimiteReserva(Date dataLimiteReserva) {
        this.dataLimiteReserva = dataLimiteReserva;
    }

    public char getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(char statusReserva) {
        this.statusReserva = statusReserva;
    }
}
