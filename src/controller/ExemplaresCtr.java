package controller;

import boundery.TelaCadExemplar;
import model.bean.Cliente;
import model.bean.Exemplar;
import model.bean.Livro;
import model.dao.ExemplarDao;
import model.dao.LivroDao;

import java.util.ArrayList;
import java.util.List;

public class ExemplaresCtr {

    LivroDao livroDao = new LivroDao();
    ExemplarDao exemplarDao = new ExemplarDao();
    TelaCadExemplar telaCadExemplar = new TelaCadExemplar();

    public Exemplar pesqCtrlExemplar(Livro livro) {
        Exemplar exemplar = new Exemplar();
        exemplar = exemplarDao.pesquisaExemplarBD(livro);
        telaCadExemplar.setTelaExemplar(exemplar);
        return  exemplar;
    }

    public void salvaExemplar(Exemplar exemplar){
        exemplarDao.insertOrupdateExemplarBD(exemplar);
        telaCadExemplar.setTelaExemplar(exemplar);
    }

    public void editaExemplar(Exemplar exemplar){
        //Classe Dao para exemplar existente
        //exemplar = exemplarDao.editaExemplar(exemplar);
        telaCadExemplar.setTelaExemplar(exemplar);
        System.out.println("Funcionou Controle exemplar editar");
        System.out.println(exemplar);
    }

    public void limpaExemplar(){
        telaCadExemplar.restartCrudExemplar();
        System.out.println("Limpeza exemplar OK");
    }

}
