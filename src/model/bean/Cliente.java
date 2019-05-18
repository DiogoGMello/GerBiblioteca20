package model.bean;

import java.sql.Date;

public class Cliente {
    private int idCliente;
    private int pessoaID;
    private String tipoConta;
    private boolean pendenciaEmprestimo;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getPessoaID() {
        return pessoaID;
    }

    public void setPessoaID(int pessoaID) {
        this.pessoaID = pessoaID;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public boolean isPendenciaEmprestimo() {
        return pendenciaEmprestimo;
    }

    public void setPendenciaEmprestimo(boolean pendenciaEmprestimo) {
        this.pendenciaEmprestimo = pendenciaEmprestimo;
    }

    public Cliente(){
    }

}