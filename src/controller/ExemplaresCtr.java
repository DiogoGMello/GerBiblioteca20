package controller;

import model.bean.Cliente;
import model.bean.Exemplar;
import model.bean.Livro;
import model.dao.ExemplarDao;

import java.util.ArrayList;
import java.util.List;

public class ExemplaresCtr {

    public void salvaExemplar(Exemplar exemplar){

    }

    ExemplarDao classeDao = new ExemplarDao();
    Exemplar exemplar = new Exemplar();

    public Exemplar pesqExemplar(int id){
        Exemplar exemplar = new Exemplar();

        //procedure pesquisa do exemplar atraves do id

        return exemplar;
    }

    public Exemplar pesqExemplarTitulo(String titulo) {
        List<Exemplar> exemplares = new ArrayList();
        LivrosCtr livrosCtr = new LivrosCtr();
        Livro livro = livrosCtr.pesqLivroTitulo(titulo);
        int idLivro = livro.getIdLivro();

        for(Exemplar busca : exemplares){
            if(busca.getIdExemplar() == idLivro){
                exemplar = busca;
            }
        }
        return exemplar;
    }

    public void deletaExemplar(int id){

    }
}
