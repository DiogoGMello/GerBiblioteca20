package boundery;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuLateral{

    Stage window;
    Scene sceneMenu;
    Label menuIdentificacao;
    Button btnEmprestimo, btnCliente, btnExemplar, btnLivro, btnFuncionario, btnGenero, btnEditora, btnAutor, btnConfiguracao;

//    public static void main(String[] args) {
  //      launch(args);
    //}

    public VBox menuMontagem() throws Exception {

        menuIdentificacao = new Label("MENU");
        btnEmprestimo = new Button("Emprestimos");
        btnEmprestimo.setMinWidth(150);

        btnCliente = new Button("Clientes");
        btnCliente.setMinWidth(150);

        btnExemplar = new Button("Exemplares");
        btnExemplar.setMinWidth(150);

        btnLivro = new Button("Livros");
        btnLivro.setMinWidth(150);

        btnFuncionario = new Button("Funcionarios");
        btnFuncionario.setMinWidth(150);

        btnGenero = new Button("Generos");
        btnGenero.setMinWidth(150);

        btnEditora = new Button("Editoras");
        btnEditora.setMinWidth(150);

        btnAutor = new Button("Autores");
        btnAutor.setMinWidth(150);

        btnConfiguracao = new Button("Configurações");
        btnConfiguracao.setMinWidth(150);


        VBox layoutMenuLateral = new VBox(15);
        layoutMenuLateral.setBorder(new Border(
                new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));
        layoutMenuLateral
                .getChildren()
                .addAll(menuIdentificacao, btnEmprestimo, btnCliente, btnExemplar,
                btnLivro, btnFuncionario, btnGenero, btnEditora, btnAutor, btnConfiguracao);
        layoutMenuLateral.setPadding(new Insets(20,10,20,10));

        return layoutMenuLateral;
    }
}
