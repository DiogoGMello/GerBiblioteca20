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

    //LivroDao livroDao = new LivroDao();
    TelaCadExemplar telaCadExemplar = new TelaCadExemplar();

    public Exemplar pesqCtrlExemplar(Livro livro){
        Exemplar exemplar = new Exemplar();

        if(livro.getTitulo() != null || livro.getTitulo() != ""){
            //Classe dao para buscar por titulo
            //exemplar = exemplarDao.pesqPorTitulo(livro.getTitulo());
            System.out.println("Busca por titulo " + livro.getTitulo());
            telaCadExemplar.setTelaExemplar(exemplar);
            return exemplar;
        }else {
            //Classe dao para buscar por subtitulo
            //exemplar = exemplarDao.pesqPorSubTitulo(livro.getSubTitulo());
            System.out.println("Busca por Subtitulo " + livro.getSubTitulo());
            telaCadExemplar.setTelaExemplar(exemplar);
            return exemplar;
        }
    }

    public void salvaExemplar(Exemplar exemplar){
        //Classe dao de salvar exemplar
        //a classe DAO deve retornar o objeto exemplar com o ID incluso
        //exemplar = exemplarDao.salvarNovoExemplar(exemplar);
        telaCadExemplar.setTelaExemplar(exemplar);
        System.out.println("Funcionou Controle exemplar Salvar");
        System.out.println(exemplar);
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
