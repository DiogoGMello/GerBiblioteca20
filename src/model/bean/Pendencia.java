package model.bean;

import java.sql.Date;

public class Pendencia {

    private int ID_Pendencia;
    private int dias_suspensao;
    private Date dt_suspensao;
    private double valor_suspensao;
    private String fl_tp_dano;
    private boolean fl_pagamento;
    private String status_pendencia;

    public Pendencia(){
    }

    public int getID_Pendencia() {
        return ID_Pendencia;
    }

    public void setID_Pendencia(int ID_Pendencia) {
        this.ID_Pendencia = ID_Pendencia;
    }

    public int getDias_suspensao() {
        return dias_suspensao;
    }

    public void setDias_suspensao(int dias_suspensao) {
        this.dias_suspensao = dias_suspensao;
    }

    public Date getDt_suspensao() {
        return dt_suspensao;
    }

    public void setDt_suspensao(Date dt_suspensao) {
        this.dt_suspensao = dt_suspensao;
    }

    public double getValor_suspensao() {
        return valor_suspensao;
    }

    public void setValor_suspensao(double valor_suspensao) {
        this.valor_suspensao = valor_suspensao;
    }

    public String getFl_tp_dano() {
        return fl_tp_dano;
    }

    public void setFl_tp_dano(String fl_tp_dano) {
        this.fl_tp_dano = fl_tp_dano;
    }

    public boolean isFl_pagamento() {
        return fl_pagamento;
    }

    public void setFl_pagamento(boolean fl_pagamento) {
        this.fl_pagamento = fl_pagamento;
    }

    public String getStatus_pendencia() {
        return status_pendencia;
    }

    public void setStatus_pendencia(String status_pendencia) {
        this.status_pendencia = status_pendencia;
    }
}
