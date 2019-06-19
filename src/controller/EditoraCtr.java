package controller;

import boundery.TelaCadEditora;
import model.bean.Editora;
import model.dao.EditoraDao;

public class EditoraCtr {
    EditoraDao editoraDao = new EditoraDao();
    TelaCadEditora tela = new TelaCadEditora();

    public  Editora pesqCtrlEditora(String nome){
        Editora editora = new Editora();
        tela.setTelaEditora(editoraDao.pesquisaEditoraBD(nome));
        return editora;
    }

    public void salvaEditora(Editora editora){
        tela.setTelaEditora(editoraDao.createEditoraBD(editora));
    }

    public void editaEditora(Editora editora){
        //classe dao para editar
        tela.setTelaEditora(editora);
        System.out.println("Alterar Editora ok");
        System.out.println(editora);
    }

    public void limpaEditora(){
        tela.restartCrudEditora();
        System.out.println("Limpeza de tela OK");
    }
}
