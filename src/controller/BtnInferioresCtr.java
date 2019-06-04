package controller;

public class BtnInferioresCtr {

    EmprestimoCtr emprestimoCtr = new EmprestimoCtr();
    ClienteCtr clienteCtr = new ClienteCtr();
    ExemplaresCtr exemplaresCtr = new ExemplaresCtr();
    LivrosCtr livrosCtr = new LivrosCtr();
    FuncionariosCtr funcionariosCtr = new FuncionariosCtr();
    EditoraCtr editoraCtr = new EditoraCtr();
    AutorCtr autorCtr = new AutorCtr();

    public void funcaoSalvar(){
        switch(BtnLateralControler.titulo.getText()){
            case "EMPRESTIMO":
                break;
            case "CLIENTE":
                clienteCtr.salvaCliente();
                break;
            case "EXEMPLAR":
                break;
            case "LIVROS":
                break;
            case "FUNCIONARIOS":
                break;
            case "EDITORA":
                break;
            case "AUTORES":
                autorCtr.salvarAutor();
                break;
        }

    }

    public void funcaoNovo(){
        switch(BtnLateralControler.titulo.getText()){
            case "EMPRESTIMO":

                break;
            case "CLIENTE":
                break;
            case "EXEMPLAR":
                break;
            case "LIVROS":
                break;
            case "FUNCIONARIOS":
                break;
            case "EDITORA":
                break;
            case "AUTORES":
                break;
        }
    }

    public void funcaoDeletar(){
        switch(BtnLateralControler.titulo.getText()){
            case "EMPRESTIMO":

                break;
            case "CLIENTE":
                break;
            case "EXEMPLAR":
                break;
            case "LIVROS":
                break;
            case "FUNCIONARIOS":
                break;
            case "EDITORA":
                break;
            case "AUTORES":
                break;
        }
    }
}
