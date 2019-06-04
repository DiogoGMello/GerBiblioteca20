package controller;

import boundery.TelaCadEditora;
import model.bean.Cliente;
import model.bean.Editora;
import model.dao.EditoraDao;

import java.util.ArrayList;
import java.util.List;

public class EditoraCtr {
    EditoraDao procEditora = new EditoraDao();
    Editora editora = new Editora();
    TelaCadEditora tela = new TelaCadEditora();

    public void salvaEditora(){
        editora = tela.coletaEditora();

        procEditora.salvarEditoraBD(editora);

    }

    public Editora pesqEditora(int id){
        Editora editora = new Editora();

        //Procedure de pesquisa da editora, atraves do id

        return editora;
    }

    public Editora pesqEditoraNome(String nome) {
        List<Editora> editoras = new ArrayList();
        Editora editora = new Editora();
        editoras = procEditora.encontrarEditoraBDTodos();

        for(Editora busca : editoras) {
            if(busca.getNome() == nome)
                editora = busca;
        }
        return editora;
    }

    public void deletaEditora(int id){

    }
}
