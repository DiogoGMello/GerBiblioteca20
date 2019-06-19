package model.bean;

import java.util.Date;

public class Editora {

    private int idEditora;
    private String nome;
    private String revendedor;
    private String contato;
    private String contatoRevendedor;
    private String email;
    private String emailRevendedor;
    private Date dataCriacao;
    private boolean status;

    public Editora(){
        idEditora = 0;
        nome = "Não Cadastrado";
        revendedor = "Não Cadastrado";
        contato = "Não Cadastrado";
        contatoRevendedor = "Não Cadastrado";
        email = "Não Cadastrado";
        emailRevendedor = "Não Cadastrado";
    }

    @Override
    public String toString(){
        String dev = "fim";

        System.out.println(idEditora);
        System.out.println(nome);
        System.out.println(revendedor);
        System.out.println(contato);
        System.out.println(contatoRevendedor);
        System.out.println(email);
        System.out.println(emailRevendedor);

        return dev;
    }

    public boolean getStatus()
    {
        return this.status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public Date getDataCriacao()
    {
        return this.dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(String revendedor) {
        this.revendedor = revendedor;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getContatoRevendedor() {
        return contatoRevendedor;
    }

    public void setContatoRevendedor(String contatoRevendedor) {
        this.contatoRevendedor = contatoRevendedor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailRevendedor() {
        return emailRevendedor;
    }

    public void setEmailRevendedor(String emailRevendedor) {
        this.emailRevendedor = emailRevendedor;
    }
}
