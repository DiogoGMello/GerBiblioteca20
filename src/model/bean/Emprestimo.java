package model.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Emprestimo {
    private int idEmprestimo;
    private Cliente cliente;
    private int idCliente;
    private int idExemplar;

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    private Exemplar exemplar;
    private Date dataEmprestimo;
    private Date dataDevEfetiva;
    private int funcionarioID;
    private boolean statusEmprestimo;
    private Date dataDevPrevista;

    public Emprestimo(){
        this.idEmprestimo = 0;
        this.dataEmprestimo = null;
        this.dataDevEfetiva = null;
        this.funcionarioID = 0;
        this.statusEmprestimo = false;
        this.dataDevPrevista = null;
        this.exemplar = new Exemplar();
        this.cliente = new Cliente();

    }

    public Emprestimo(int idEmprestimo, Date dataEmprestimo,
                      Date dataDevEfetiva, int funcionarioID, boolean statusEmprestimo) {
        this.idEmprestimo = idEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevEfetiva = dataDevEfetiva;
        this.funcionarioID = funcionarioID;
        this.statusEmprestimo = statusEmprestimo;
    }

    public Date getDataDevPrevista() {
        return dataDevPrevista;
    }

    public void setDataDevPrevista(Date dataDevPrevista) {
        this.dataDevPrevista = dataDevPrevista;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
//
//    public Exemplar getExemplar() {

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }
//        return exemplar;
//    }
//
//    public void setExemplar(Exemplar exemplar) {
//        this.exemplar = exemplar;
//    }
//
//    public Exemplar getExemplar02() {
//        return exemplar02;
//    }
//
//    public void setExemplar02(Exemplar exemplar02) {
//        this.exemplar02 = exemplar02;
//    }
//
//    public Exemplar getExemplar03() {
//        return exemplar03;
//    }
//
//    public void setExemplar03(Exemplar exemplar03) {
//        this.exemplar03 = exemplar03;
//    }

    public Date getDataEmprestimo() {
        Date date = new Date();
        date.getTime();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        formatDate.format(date);
        return date;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevEfetiva() {
        return dataDevEfetiva;
    }

    public void setDataDevEfetiva(Date dataDevEfetiva) {
        this.dataDevEfetiva = dataDevEfetiva;
    }

    public int getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(int funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public boolean isStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(boolean statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }

    public Date geraDataPrevista(){
        Calendar c = Calendar.getInstance();
        c.setTime(dataEmprestimo);
        c.add(Calendar.DATE, +7);
        return c.getTime();
    }
}