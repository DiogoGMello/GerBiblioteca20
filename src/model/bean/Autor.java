package model.bean;

import java.util.Date;

public class Autor {

    private int idAutor;
    private String nomeAutor;
    private String paisOrigem;
    private String especialidade;
    private Date dataCriacao;
    private boolean status;

    public Autor(){
        idAutor = 0;
        nomeAutor = "Não Preenchido";
        paisOrigem = "Não Preenchido";
        especialidade = "Não preenchido";
    }

    public Date getDataCriacao()
    {
        return this.dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }

    public boolean getStatus()
    {
        return this.status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomeoAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString(){
        String result = "";

        System.out.println("Id Autor é " + idAutor);
        System.out.println("Nome Nome autor é " + nomeAutor);
//        System.out.println("Nome data Nascimento é " + dataNascimento);
        System.out.println("Nome pais origem é " + paisOrigem);
        System.out.println("Nome especialidade é " + especialidade);

        return result;
    }
}
