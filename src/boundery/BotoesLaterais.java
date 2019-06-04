package boundery;

import controller.BtnLateralControler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import principal.MainBiblioteca;

public class BotoesLaterais {


    Label menuIdentificacao;
    Button btnInicio, btnEmprestimo, btnCliente, btnExemplar, btnLivro, btnFuncionario, btnGenero,
            btnEditora, btnAutor, btnConfiguracao;

    public VBox menuMontagem(){

        BtnLateralControler menuControler = new BtnLateralControler();

        menuIdentificacao = new Label("MENU");

        btnInicio = new Button("Inicio");
        btnInicio.setMinWidth(125);

        btnEmprestimo = new Button("Emprestimos");
        btnEmprestimo.setMinWidth(125);
        btnEmprestimo.setOnAction(e->
                MainBiblioteca.scnPrincipal
                        .setRoot(menuControler.crudEmprestimo()));

        btnCliente = new Button("Clientes");
        btnCliente.setMinWidth(125);
        btnCliente.setOnAction(e->
                MainBiblioteca.scnPrincipal
                        .setRoot(menuControler.crudCliente()));

        btnExemplar = new Button("Exemplares");
        btnExemplar.setMinWidth(125);
        btnExemplar.setOnAction(e->
                MainBiblioteca.scnPrincipal
                        .setRoot(menuControler.crudExemplar()));

        btnLivro = new Button("Livros");
        btnLivro.setMinWidth(125);
        btnLivro.setOnAction(e-> MainBiblioteca
                .scnPrincipal
                .setRoot(menuControler.crudLivros()));

        btnFuncionario = new Button("Funcionarios");
        btnFuncionario.setMinWidth(125);
        btnFuncionario.setOnAction(e-> MainBiblioteca
                .scnPrincipal
                .setRoot(menuControler.crudFuncionario()));

        btnGenero = new Button("Generos");
        btnGenero.setMinWidth(125);
        //btnExemplar.setOnAction(e-> MainBiblioteca.scnPrincipal.setRoot);

        btnEditora = new Button("Editoras");
        btnEditora.setMinWidth(125);
        btnEditora.setOnAction(e-> MainBiblioteca
                .scnPrincipal
                .setRoot(menuControler.crudEditora()));

        btnAutor = new Button("Autores");
        btnAutor.setMinWidth(125);
        btnAutor.setOnAction(e-> MainBiblioteca
                .scnPrincipal
                .setRoot(menuControler.crudAutores()));

        btnConfiguracao = new Button("Configurações");
        btnConfiguracao.setMinWidth(125);
        btnConfiguracao.setOnAction(e-> MainBiblioteca
                .scnPrincipal
                .setRoot(menuControler.crudConfiguracao()));

        VBox layoutMenuLateral = new VBox(15);
        layoutMenuLateral.setBorder(new Border(
                new BorderStroke(Color.LIGHTGRAY,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        BorderWidths.DEFAULT)));
        layoutMenuLateral
                .getChildren()
                .addAll(menuIdentificacao, btnInicio, btnEmprestimo, btnCliente, btnExemplar,
                        btnLivro, btnFuncionario, btnGenero, btnEditora, btnAutor, btnConfiguracao);
        layoutMenuLateral.setPadding(new Insets(20,10,20,10));

        return layoutMenuLateral;
    }
}
