package model.bean;

public class Editora {

    private int idEditora;
    private String nome;
    private String revendedor;
    private String contato;
    private String contatoRevendedor;
    private String email;
    private String emailRevendedor;

    public Editora(){
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
