package controller;

import boundery.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class BtnLateralControler {

    public static BorderPane layoutPrincipal = new BorderPane();
    BotoesLaterais menuLateral = new BotoesLaterais();
    BotoesInferiores botoesCrud = new BotoesInferiores();
    StackPane layoutTitulo = new StackPane();
    public static Label titulo = new Label();
    public static int locTela = 0;

    public BorderPane crudEmprestimo(){
        TelaCadEmprestimo telaCadEmprestimo = new TelaCadEmprestimo();

        titulo.setText("EMPRESTIMO");
        locTela = 2;
        layoutTitulo.getChildren().add(titulo);
        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(layoutTitulo);
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadEmprestimo.geraCrudEmprestimo());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudCliente(){
        TelaCadCliente telaCadCliente = new TelaCadCliente();

        titulo.setText("CLIENTE");
        locTela = 3;
        layoutTitulo.getChildren().add(titulo);
        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(layoutTitulo);
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadCliente.geraCrudCliente());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudExemplar(){
        TelaCadExemplar telaCadExemplar = new TelaCadExemplar();

        titulo.setText("EXEMPLAR");
        locTela = 4;
        layoutTitulo.getChildren().add(titulo);
        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(layoutTitulo);
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadExemplar.geraCrudExemplar());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudLivros(){
        TelaCadLivro telaCadLivros = new TelaCadLivro();

        titulo.setText("LIVROS");
        locTela = 5;
        layoutTitulo.getChildren().add(titulo);
        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(layoutTitulo);
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadLivros.geraCrudLivro());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudFuncionario(){
        TelaCadFuncionario telaCadFuncionario = new TelaCadFuncionario();

        titulo.setText("FUNCIONARIOS");
        locTela = 6;
        layoutTitulo.getChildren().add(titulo);
        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(layoutTitulo);
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadFuncionario.geraCrudFuncionarios());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudEditora(){
        TelaCadEditora telaCadEditora = new TelaCadEditora();

        titulo.setText("EDITORA");
        locTela = 7;
        layoutTitulo.getChildren().add(titulo);
        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(layoutTitulo);
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadEditora.geraCrudEditora());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudAutores(){
        TelaCadAutores telaCadAutores = new TelaCadAutores();

        titulo.setText("AUTORES");
        locTela = 8;
        layoutTitulo.getChildren().add(titulo);
        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(layoutTitulo);
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadAutores.geraCrudAutores());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    //Realizar ajuste da configuração mais tarde
    public BorderPane crudConfiguracao(){

        titulo.setText("CONFIGURACAO");
        layoutTitulo.getChildren().add(titulo);
        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(layoutTitulo);
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        //layoutPrincipal.setCenter(telaCadExemplar.geraCrudExemplar());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

}
