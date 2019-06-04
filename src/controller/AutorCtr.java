package controller;

import boundery.TelaCadAutores;
import model.bean.Autor;
import model.dao.AutorDao;

import java.util.ArrayList;
import java.util.List;

public class AutorCtr {

    Autor autor = new Autor();
    AutorDao procAutor = new AutorDao();
    TelaCadAutores tela = new TelaCadAutores();

    public void salvarAutor(){
        Autor autor = new Autor();

        autor = tela.coletaAutor();

        procAutor.salvarAutorBD(autor);
    }

    public void deletarAutor(int id){
        //Terá a procedure que irá Deletar o Autor
    }

    public Autor pesqAutorNome(String nome) {
        List<Autor> autores = new ArrayList();
        autores = procAutor.encontrarAutorBDTodos();

        for(Autor busca : autores) {
            if(busca.getNomeoAutor() == nome)
                autor = busca;
        }
        return autor;
    }


}
