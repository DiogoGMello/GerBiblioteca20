package controller;

import model.bean.Cliente;
import model.bean.Livro;
import model.dao.LivroDao;

import java.util.ArrayList;
import java.util.List;

public class LivrosCtr {

    public void salvaLivro(Livro livro){

    }

    LivroDao procLivro = new LivroDao();
    Livro livro = new Livro();

    public Livro pesqLivro(int id){
        Livro livro = new Livro();

        return livro;
    }

    public Livro pesqLivroTitulo(String titulo) {
        List<Livro> livros = new ArrayList();
        livros = procLivro.encontrarLivroBDTodos();

        for(Livro busca : livros) {
            if(busca.getTitulo() == titulo)
                livro = busca;
        }
        return livro;
    }

    public void deletaLivro(int id){

    }
}
