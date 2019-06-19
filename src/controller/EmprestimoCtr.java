package controller;

import boundery.TelaCadEmprestimo;
import model.bean.Emprestimo;
import model.dao.EmprestimoDao;

public class EmprestimoCtr {
    Emprestimo emprestimo = new Emprestimo();
    EmprestimoDao emprestimoDao = new EmprestimoDao();


    public Emprestimo pesqCtrlEmprestimo(String nome){
        TelaCadEmprestimo tela = new TelaCadEmprestimo();
        //Classe dao de busca por nome do cliente
        //emprestimo = emprestimoDao.procuraEmprestimo(nome);
        tela.setTelaEmprestimo(emprestimo);
        System.out.println("Funcionou controle emprestimo pesquisa");
        return emprestimo;
    }

    public void salvaEmprestimo(Emprestimo emprestimo){
        TelaCadEmprestimo tela = new TelaCadEmprestimo();
        //Classe dao de salvar emprestimo
        //a classe DAO deve retornar o objeto emprestimo com o ID incluso
        //emprestimo = emprestimoDao.salvarNovoEmprestimo(emprestimo);
        tela.setTelaEmprestimo(emprestimo);
        System.out.println("Funcionou Controle emprestimo Salvar");
        System.out.println(emprestimo);
    }

    public void editaEmprestimo(Emprestimo emprestimo){
        TelaCadEmprestimo tela = new TelaCadEmprestimo();
        //Classe Dao para emprestimo existente
        //emprestimo = emprestimoDao.editaEmprestimo(emprestimo);
        tela.setTelaEmprestimo(emprestimo);
        System.out.println("Funcionou Controle emprestimo editar");
        System.out.println(emprestimo);
    }

    public void limpaEmprestimo(){
        TelaCadEmprestimo tela = new TelaCadEmprestimo();
        tela.restartCrudEmprestimo();
        System.out.println("Limpeza emprestimo OK");
    }
}
