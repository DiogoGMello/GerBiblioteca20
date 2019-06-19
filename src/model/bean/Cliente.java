package model.bean;

public class Cliente extends Pessoa{

    private int idCliente;
    private String tipoConta;
    private boolean pendenciaEmprestimo;

    public Cliente(){
        idCliente = 0;
        setNome("");
        setCpf("");
        setEndereco("");
        setNumeroEndereco("");
        setBairro("");
        setCep("");
        setCidade("");
        setEstado("");
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    @Override
    public String toString(){
        String dev = "fim";

        System.out.println(idCliente);
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