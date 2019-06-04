package model.bean;

import java.sql.Date;

public class Funcionario extends Pessoa{
    private int idFuncionario;
    private int pessoaID;
    private Date dataInicioContrato;
    private Date dataTerminoContrato;

    public Funcionario(){
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getPessoaID() {
        return pessoaID;
    }

    public void setPessoaID(int pessoaID) {
        this.pessoaID = pessoaID;
    }

    public Date getDataInicioContrato() {
        return dataInicioContrato;
    }

    public void setDataInicioContrato(Date dataInicioContrato) {
        this.dataInicioContrato = dataInicioContrato;
    }

    public Date getDataTerminoContrato() {
        return dataTerminoContrato;
    }

    public void setDataTerminoContrato(Date dataTerminoContrato) {
        this.dataTerminoContrato = dataTerminoContrato;
    }

}