package controller;

import boundery.TelaCadEmprestimo;
import model.bean.Emprestimo;
import model.dao.EmprestimoDao;

public class EmprestimoCtr {
    Emprestimo emprestimo = new Emprestimo();
    EmprestimoDao procEmprestimo = new EmprestimoDao();
    TelaCadEmprestimo tela = new TelaCadEmprestimo();

    public void salvaEmprestimo(Emprestimo emprestimo){




    }

    public Emprestimo pesqEmprestimo(int id){

        return emprestimo;
    }

    public void deletaEmprestimo(int id){

    }
}
