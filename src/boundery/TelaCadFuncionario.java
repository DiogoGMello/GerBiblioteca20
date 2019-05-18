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

public class TelaCadFuncionario extends Application {

    Stage window;

    Label lblPesquisa, lblPesqNome, lblPesqCPF, lblCadastro, lblID, lblCPF, lblNome, lblEndereco, lblNumero, lblBairro,
            lblCEP, lblCidade, lblEstado, lblDtCadastro, lblStatus;
    TextField txtPesqNome, txtPesqCPF, txtID, txtCPF, txtNome, txtEndereco, txtNumero, txtBairro, txtCEP,
            txtCidade, txtEstado, txtDtCadastro, txtStatus;
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
        lblPesqCPF = new Label("CPF");
        txtPesqCPF = new TextField();
        btnPesquiar = new Button("Search");

        layoutPesquisa.getChildren().addAll(lblPesqNome, txtPesqNome, lblPesqCPF, txtPesqCPF, btnPesquiar);

        //Campos de cadastro
        lblCadastro = new Label("CADASTRO");

        lblID = new Label("ID");
        layoutCentral.setConstraints(lblID, 0, 0);
        txtID = new TextField();
        layoutCentral.setConstraints(txtID, 1,0);
        lblCPF = new Label("CPF");
        layoutCentral.setConstraints(lblCPF, 2, 0);
        txtCPF = new TextField();
        layoutCentral.setConstraints(txtCPF, 3,0);

        lblNome = new Label("Nome");
        layoutCentral.setConstraints(lblNome, 0, 1);
        txtNome = new TextField();
        layoutCentral.setConstraints(txtNome, 1,1);

        lblEndereco = new Label("Endereço");
        layoutCentral.setConstraints(lblEndereco, 0, 2);
        txtEndereco = new TextField();
        layoutCentral.setConstraints(txtEndereco, 1,2);

        lblNumero = new Label("Número");
        layoutCentral.setConstraints(lblNumero, 0, 3);
        txtNumero = new TextField();
        layoutCentral.setConstraints(txtNumero, 1,3);
        lblBairro = new Label("Bairro");
        layoutCentral.setConstraints(lblBairro, 2, 3);
        txtBairro = new TextField();
        layoutCentral.setConstraints(txtBairro,3,3);
        lblCEP = new Label("CEP");
        layoutCentral.setConstraints(lblCEP, 4, 3);
        txtCEP = new TextField();
        layoutCentral.setConstraints(txtCEP, 5,3);

        lblCidade = new Label("Cidade");
        layoutCentral.setConstraints(lblCidade, 0, 4);
        txtCidade = new TextField();
        layoutCentral.setConstraints(txtCidade, 1,4);
        lblEstado = new Label("Estado");
        layoutCentral.setConstraints(lblEstado, 2, 4);
        txtEstado = new TextField();
        layoutCentral.setConstraints(txtEstado, 3,4);

        lblDtCadastro = new Label("Data Cadastro");
        layoutCentral.setConstraints(lblDtCadastro, 0, 5);
        txtDtCadastro = new TextField();
        layoutCentral.setConstraints(txtDtCadastro, 1,5);
        lblStatus = new Label("Status");
        layoutCentral.setConstraints(lblStatus, 2, 5);
        txtStatus = new TextField();
        layoutCentral.setConstraints(txtStatus, 3,5);

        btnNovo = new Button("Novo");
        btnNovo.setMinWidth(100);
        btnLimpar = new Button("Limpar");
        btnLimpar.setMinWidth(100);
        btnSalvar = new Button("Salvar");
        btnSalvar.setMinWidth(100);

        layoutBotoes.getChildren().addAll(btnNovo, btnLimpar, btnSalvar);

        layoutCentral.getChildren().addAll(lblPesquisa, lblID, txtID, lblCPF, txtCPF, lblNome, txtNome, lblEndereco,
                txtEndereco, lblNumero, txtNumero, lblBairro, txtBairro, lblCEP, txtCEP, lblCidade, txtCidade,
                lblEstado, txtEstado, lblDtCadastro, txtDtCadastro, lblStatus, txtStatus);

        layoutOrganizacao.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral, layoutBotoes);

        Scene scn = new Scene(layoutOrganizacao, 750, 500);

        window.setScene(scn);
        window.show();
    }
}
