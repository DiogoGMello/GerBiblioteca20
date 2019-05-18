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

public class TelaCadExemplar extends Application {

    Stage window;

    Label lblPesquisa, lblPesqTitulo, lblPesqSubtitulo, lblCadastro, lblID, lblLivroID, lblTitulo,
            lblSubtitulo, lblNSerie, lblCondicao, lblStatus, lblEmprestimoID, lblDtAquisicao, lblDtRemocao;

    TextField txtPesqTitulo, txtPesqSubtitulo, txtID, txtLivroID, txtTitulo, txtSubtitulo, txtNSerie, txtCondicao,
            txtStatus, txtEmprestimoID, txtDtAquisicao, txtDtRemocao;

    Button btnPesquiar, btnNovo, btnLimpar, btnSalvar, btnPesqLivro;

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

        lblPesqTitulo = new Label("Titulo");
        txtPesqTitulo = new TextField();
        lblPesqSubtitulo = new Label("Subtitulo");
        txtPesqSubtitulo = new TextField();
        btnPesquiar = new Button("Search");

        layoutPesquisa.getChildren().addAll(lblPesqTitulo, txtPesqTitulo, lblPesqSubtitulo, txtPesqSubtitulo, btnPesquiar);

        //Campos de cadastro
        lblCadastro = new Label("CADASTRO");

        lblID = new Label("ID");
        layoutCentral.setConstraints(lblID, 0, 0);
        txtID = new TextField();
        layoutCentral.setConstraints(txtID, 1,0);
        lblLivroID = new Label("Livro ID");
        layoutCentral.setConstraints(lblLivroID, 2, 0);
        txtLivroID = new TextField();
        layoutCentral.setConstraints(txtLivroID, 3,0);
        btnPesqLivro = new Button("Pesq Livro");
        layoutCentral.setConstraints(btnPesqLivro, 4,0);

        lblTitulo = new Label("Titulo");
        layoutCentral.setConstraints(lblTitulo, 0, 1);
        txtTitulo = new TextField();
        layoutCentral.setConstraints(txtTitulo, 1,1);

        lblSubtitulo = new Label("SubTitulo");
        layoutCentral.setConstraints(lblSubtitulo, 0, 2);
        txtSubtitulo = new TextField();
        layoutCentral.setConstraints(txtSubtitulo, 1,2);

        lblNSerie = new Label("N Serie");
        layoutCentral.setConstraints(lblNSerie, 0, 3);
        txtNSerie = new TextField();
        layoutCentral.setConstraints(txtNSerie, 1,3);

        lblCondicao = new Label("Condição");
        layoutCentral.setConstraints(lblCondicao, 0, 4);
        txtCondicao = new TextField();
        layoutCentral.setConstraints(txtCondicao,1,4);

        lblStatus = new Label("Status");
        layoutCentral.setConstraints(lblStatus, 0, 5);
        txtStatus = new TextField();
        layoutCentral.setConstraints(txtStatus, 1,5);
        lblEmprestimoID = new Label("Empretimo ID");
        layoutCentral.setConstraints(lblEmprestimoID, 2, 5);
        txtEmprestimoID = new TextField();
        layoutCentral.setConstraints(txtEmprestimoID, 3,5);

        lblDtAquisicao = new Label("Aquisição");
        layoutCentral.setConstraints(lblDtAquisicao, 0, 6);
        txtDtAquisicao = new TextField();
        layoutCentral.setConstraints(txtDtAquisicao, 1,6);
        lblDtRemocao = new Label("Remoção");
        layoutCentral.setConstraints(lblDtRemocao, 2, 6);
        txtDtRemocao = new TextField();
        layoutCentral.setConstraints(txtDtRemocao, 3,6);

        layoutCentral.getChildren().addAll(lblPesquisa, lblID, txtID, lblLivroID, txtLivroID, btnPesqLivro,
                lblTitulo, txtTitulo, lblSubtitulo, txtSubtitulo, lblNSerie, txtNSerie, lblCondicao, txtCondicao,
                lblStatus, txtStatus, lblEmprestimoID, txtEmprestimoID, lblDtAquisicao, txtDtAquisicao,
                lblDtRemocao, txtDtRemocao);

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
