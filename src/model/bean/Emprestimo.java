package model.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Emprestimo {
    private int idEmprestimo;
    private Cliente cliente;
    private Exemplar exemplar;
    private Date dataEmprestimo;
    private Date dataDevEfetiva;
    private int funcionarioID;
    private boolean statusEmprestimo;

    public Emprestimo(){
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

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

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