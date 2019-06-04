package controller;

import boundery.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import principal.MainBiblioteca;

public class BtnLateralControler {

    BotoesLaterais menuLateral = new BotoesLaterais();
    BotoesInferiores botoesCrud = new BotoesInferiores();
    public static BorderPane layoutPrincipal = new BorderPane();
    StackPane layoutTitulo = new StackPane();
    public static Label titulo = new Label();

    public BorderPane crudEmprestimo(){
        TelaCadEmprestimo telaCadEmprestimo = new TelaCadEmprestimo();

        titulo.setText("EMPRESTIMO");
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
