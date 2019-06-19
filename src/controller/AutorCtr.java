package controller;

import boundery.TelaCadAutores;
import model.bean.Autor;
import model.dao.AutorDao;

import java.util.ArrayList;
import java.util.List;

public class AutorCtr {

    AutorDao autorDao = new AutorDao();
    TelaCadAutores tela = new TelaCadAutores();

    public void pesqCtlrAutor(String nome){
        tela.setTelaAutor(autorDao.pesquisaAutorBD(nome));
    }

    public void salvaAutor(Autor autor){
        tela.setTelaAutor(autorDao.createAutorBD(autor));
    }

    public void limpaAutor(){
        tela.restartCrud();
        System.out.println("Limpeza autor OK");
    }
}
