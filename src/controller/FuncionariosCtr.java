package controller;

import boundery.TelaCadFuncionario;
import model.bean.Funcionario;
import model.dao.FuncionarioDao;

public class FuncionariosCtr {
    TelaCadFuncionario telaCadFuncionario = new TelaCadFuncionario();
    FuncionarioDao funcionarioDao = new FuncionarioDao();

    public void pesqCtrlFuncionario(Funcionario funcionario){
        telaCadFuncionario.setTelaFuncionario(
                funcionarioDao.pesquisaFuncionarioBD(funcionario)
        );
    }

    public void salvaFuncionario(Funcionario funcionario){

        telaCadFuncionario.setTelaFuncionario(
                funcionarioDao.createOrUpdateFuncionario(funcionario)
        );
    }

    public void editaFuncionario(Funcionario funcionario){
        //Salva o funcionario de acordo com o id
        //funcionario = funcionarioDao.editaFuncionario(funcionario);
        System.out.println("Edita funcionario corretamente");
        telaCadFuncionario.setTelaFuncionario(funcionario);
    }

    public void limpaFuncionario(){
        System.out.println("Limpa funcionario ok");
        telaCadFuncionario.restartCrudFuncionario();
    }
}
