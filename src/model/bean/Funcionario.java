package model.bean;

import java.util.Date;

public class Funcionario extends Pessoa{
    private int idFuncionario;
    private Date dataInicioContrato;
    private Date dataTerminoContrato;

    public Funcionario(){
        idFuncionario = 0;
        setNome("Não cadastrado");
        setCpf("");
        setEndereco("Não cadastrado");
        setNumeroEndereco("");
        setBairro("Não cadastrado");
        setCep("");
        setCidade("Não cadastrado");
        setEstado("Não cadastrado");
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    @Override
    public String toString(){
        String dev = "fim";

        System.out.println(idFuncionario);
        System.out.println(getNome());
        System.out.println(getCpf());
        System.out.println(getEndereco());
        System.out.println(getNumeroEndereco());
        System.out.println(getBairro());
        System.out.println(getCep());
        System.out.println(getCidade());
        System.out.println(getEstado());

        return dev;
    }

}