package controller;

import boundery.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MenuLateralControler {

    BotoesLaterais menuLateral = new BotoesLaterais();
    BotoesInferiores botoesCrud = new BotoesInferiores();
    public static BorderPane layoutPrincipal = new BorderPane();

    public BorderPane crudEmprestimo(){
        TelaCadEmprestimo telaCadEmprestimo = new TelaCadEmprestimo();

        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(new Label("EMPRESTIMO"));
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadEmprestimo.geraCrudEmprestimo());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudCliente(){
        TelaCadCliente telaCadCliente = new TelaCadCliente();

        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(new Label("CLIENTES"));
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadCliente.geraCrudCliente());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudExemplar(){
        TelaCadExemplar telaCadExemplar = new TelaCadExemplar();

        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(new Label("EXEMPLARES"));
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadExemplar.geraCrudExemplar());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudLivros(){
        TelaCadLivro telaCadLivros = new TelaCadLivro();

        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(new Label("EXEMPLARES"));
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadLivros.geraCrudLivro());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudFuncionario(){
        TelaCadFuncionario telaCadFuncionario = new TelaCadFuncionario();

        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(new Label("FUNCIONARIOS"));
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadFuncionario.geraCrudFuncionarios());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudEditora(){
        TelaCadEditora telaCadEditora = new TelaCadEditora();

        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(new Label("EDITORA"));
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadEditora.geraCrudEditora());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    public BorderPane crudAutores(){
        TelaCadAutores telaCadAutores = new TelaCadAutores();

        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(new Label("EXEMPLARES"));
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        layoutPrincipal.setCenter(telaCadAutores.geraCrudAutores());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

    //Realizar ajuste da configuração mais tarde
    public BorderPane crudConfiguracao(){

        layoutPrincipal.setPadding(new Insets(40));
        layoutPrincipal.setTop(new Label("EXEMPLARES"));
        layoutPrincipal.setLeft(menuLateral.menuMontagem());
        //layoutPrincipal.setCenter(telaCadExemplar.geraCrudExemplar());
        layoutPrincipal.setBottom(botoesCrud.botoesCRUD());

        return layoutPrincipal;
    }

}
