package controller;

import boundery.TelaCadLivro;
import model.bean.Cliente;
import model.bean.Livro;
import model.dao.LivroDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivrosCtr {

    TelaCadLivro tela = new TelaCadLivro();
    LivroDao livroDao = new LivroDao();

    public Livro pesqCtrlLivro(Livro livro){

        Livro livroInt = new Livro();

        livroInt = livroDao.pesquisaLivroBD(livro.getTitulo(), livro.getSubTitulo());

        tela.setTelaLivro(livroInt);

        return livroInt;

    }

    public void salvaLivro(Livro livro){

        tela.setTelaLivro(livroDao.createOrUpdateLivroBD(livro));
    }

    public void editaLivro(Livro livro){
        //Classe Dao para livro existente
        //livro = autorDao.editaLivro(livro);
        tela.setTelaLivro(livro);
        System.out.println("Funcionou Controle livro editar");
        System.out.println(livro);
    }

    public void limpaLivro(){
        tela.restartCrudLivro();
        System.out.println("Limpeza livro OK");
    }
}
