package boundery;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaCadEditora extends Application {

    Stage window;

    Label lblPesquisa, lblPesqNome, lblCadastro, lblID, lblNome, lblRevendedor, lblContato, lblContRevendedor,
            lblEmailEditora, lblEmailRevendedor;
    TextField txtPesqNome, txtID, txtNome, txtRevendedor, txtContato, txtContRevendedor,
            txtEmailEditora, txtEmailRevendedor;
    Button btnPesquiar, btnNovo, btnLimpar, btnSalvar;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("GerBiblioteca 2.0");

        GridPane layoutCentral = new GridPane();
        layoutCentral.setPadding(new Insets(10));
        layoutCentral.setVgap(15);
        layoutCentral.setHgap(15);
        layoutCentral.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        VBox layoutOrganizacao = new VBox(10);
        layoutOrganizacao.setPadding(new Insets(10));

        HBox layoutPesquisa = new HBox(15);
        layoutPesquisa.setPadding(new Insets(10));
        layoutPesquisa.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        HBox layoutBotoes = new HBox(15);
        layoutBotoes.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        //Campos Pesquisa
        lblPesquisa = new Label("PESQUISA");

        lblPesqNome = new Label("Nome");
        txtPesqNome = new TextField();
        btnPesquiar = new Button("Search");

        layoutPesquisa.getChildren().addAll(lblPesqNome, txtPesqNome, btnPesquiar);

        //Campos de cadastro
        lblCadastro = new Label("CADASTRO");

        lblID = new Label("ID");
        layoutCentral.setConstraints(lblID, 0, 0);
        txtID = new TextField();
        layoutCentral.setConstraints(txtID, 1,0);

        lblNome = new Label("Nome");
        layoutCentral.setConstraints(lblNome, 0, 1);
        txtNome = new TextField();
        layoutCentral.setConstraints(txtNome, 1,1);

        lblRevendedor = new Label("Revendedor");
        layoutCentral.setConstraints(lblRevendedor, 0, 2);
        txtRevendedor = new TextField();
        layoutCentral.setConstraints(txtRevendedor, 1,2);

        lblContato = new Label("Contato");
        layoutCentral.setConstraints(lblContato, 0, 3);
        txtContato = new TextField();
        layoutCentral.setConstraints(txtContato, 1,3);

        lblContRevendedor = new Label("Cont. Revendedor");
        layoutCentral.setConstraints(lblContRevendedor, 0, 4);
        txtContRevendedor = new TextField();
        layoutCentral.setConstraints(txtContRevendedor,1,4);

        lblEmailEditora = new Label("Email Editora");
        layoutCentral.setConstraints(lblEmailEditora, 0, 5);
        txtEmailEditora = new TextField();
        layoutCentral.setConstraints(txtEmailEditora, 1,5);

        lblEmailRevendedor = new Label("Email Revendedor");
        layoutCentral.setConstraints(lblEmailRevendedor, 0, 6);
        txtEmailRevendedor = new TextField();
        layoutCentral.setConstraints(txtEmailRevendedor, 1,6);

        layoutCentral.getChildren().addAll(lblID, txtID, lblNome, txtNome, lblRevendedor,
                txtRevendedor, lblContato, txtContato, lblContRevendedor, txtContRevendedor,
                lblEmailEditora, txtEmailEditora, lblEmailRevendedor, txtEmailRevendedor);

        btnNovo = new Button("Novo");
        btnNovo.setMinWidth(100);
        btnLimpar = new Button("Limpar");
        btnLimpar.setMinWidth(100);
        btnSalvar = new Button("Salvar");
        btnSalvar.setMinWidth(100);

        layoutBotoes.getChildren().addAll(btnNovo, btnLimpar, btnSalvar);

        layoutOrganizacao.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral, layoutBotoes);

        Scene scn = new Scene(layoutOrganizacao, 750, 500);

        window.setScene(scn);
        window.show();
    }
}
