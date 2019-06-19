package controller;

import boundery.*;
import model.bean.*;

import java.text.ParseException;

public class BtnInferioresCtr {

    EmprestimoCtr emprestimoCtr = new EmprestimoCtr();
    TelaCadEmprestimo telaCadEmprestimo = new TelaCadEmprestimo();

    ClienteCtr clienteCtr = new ClienteCtr();
    TelaCadCliente telaCadCliente = new TelaCadCliente();

    ExemplaresCtr exemplaresCtr = new ExemplaresCtr();
    TelaCadExemplar telaCadExemplar = new TelaCadExemplar();

    LivrosCtr livrosCtr = new LivrosCtr();
    TelaCadLivro telaCadLivro = new TelaCadLivro();

    FuncionariosCtr funcionariosCtr = new FuncionariosCtr();
    TelaCadFuncionario telaCadFuncionario = new TelaCadFuncionario();

    EditoraCtr editoraCtr = new EditoraCtr();
    TelaCadEditora telaCadEditora = new TelaCadEditora();

    AutorCtr autorCtr = new AutorCtr();
    TelaCadAutores telaCadAutores = new TelaCadAutores();

    public void funcaoSalvar() throws ParseException {
        switch(BtnLateralControler.locTela){
            case 2:
                emprestimoCtr.salvaEmprestimo(telaCadEmprestimo.coletaEmprestimo());
                break;
            case 3:
                clienteCtr.salvaCliente(telaCadCliente.coletaCliente());
                break;
            case 4:
                exemplaresCtr.salvaExemplar(telaCadExemplar.coletaExemplar());
                break;
            case 5:
                livrosCtr.salvaLivro(telaCadLivro.coletaLivro());
                break;
            case 6:
                funcionariosCtr.salvaFuncionario(telaCadFuncionario.coletaFuncionario());
                break;
            case 7:
                editoraCtr.salvaEditora(telaCadEditora.coletaEditora());
                break;
            case 8:
                autorCtr.salvaAutor(telaCadAutores.coletaAutor());
                break;
        }
    }

    public void funcaoLimpar(){
        switch(BtnLateralControler.locTela){
            case 2:
                exemplaresCtr.limpaExemplar();
                break;
            case 3:
                clienteCtr.limpaCliente();
                break;
            case 4:
                exemplaresCtr.limpaExemplar();
                break;
            case 5:
                livrosCtr.limpaLivro();
                break;
            case 6:
                funcionariosCtr.limpaFuncionario();
                break;
            case 7:
                editoraCtr.limpaEditora();
                break;
            case 8:
                autorCtr.limpaAutor();
                break;
        }
    }
}
