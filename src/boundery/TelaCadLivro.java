package boundery;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TelaCadLivro{

    Label lblPesquisa, lblPesqTitulo, lblPesqSubtitulo, lblCadastro, lblID, lblGenero, lblTitulo,
            lblSubtitulo, lblAutor, lblEditora, lblSinopse, lblISBN, lblEdicao, lblAno;

    TextField txtPesqTitulo, txtPesqSubtitulo, txtID, txtGenero, txtTitulo, txtSubtitulo, txtAutor, txtEditora,
            txtISBN, txtEdicao, txtAno;

    TextArea txtSinopse;

    Button btnPesquiar;

    public VBox geraCrudLivro(){

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
        lblGenero = new Label("Genero");
        layoutCentral.setConstraints(lblGenero, 2, 0);
        txtGenero = new TextField();
        layoutCentral.setConstraints(txtGenero, 3,0);

        lblTitulo = new Label("Titulo");
        layoutCentral.setConstraints(lblTitulo, 0, 1);
        txtTitulo = new TextField();
        layoutCentral.setConstraints(txtTitulo, 1,1);

        lblSubtitulo = new Label("SubTitulo");
        layoutCentral.setConstraints(lblSubtitulo, 0, 2);
        txtSubtitulo = new TextField();
        layoutCentral.setConstraints(txtSubtitulo, 1,2);

        lblAutor = new Label("Autor");
        layoutCentral.setConstraints(lblAutor, 0, 3);
        txtAutor = new TextField();
        layoutCentral.setConstraints(txtAutor, 1,3);
        lblEditora = new Label("Editora");
        layoutCentral.setConstraints(lblEditora, 2, 3);
        txtEditora = new TextField();
        layoutCentral.setConstraints(txtEditora,3,3);

        lblSinopse = new Label("Sinopse");
        layoutCentral.setConstraints(lblSinopse, 0, 4);
        txtSinopse = new TextArea();
        layoutCentral.setConstraints(txtSinopse, 1,4);

        lblISBN = new Label("ISBN");
        layoutCentral.setConstraints(lblISBN, 0, 5);
        txtISBN = new TextField();
        layoutCentral.setConstraints(txtISBN, 1,5);
        lblAno = new Label("Ano");
        layoutCentral.setConstraints(lblAno, 2, 5);
        txtAno = new TextField();
        layoutCentral.setConstraints(txtAno, 3,5);

        lblEdicao = new Label("Edição");
        layoutCentral.setConstraints(lblEdicao, 0, 6);
        txtEdicao = new TextField();
        layoutCentral.setConstraints(txtEdicao, 1,6);

        layoutCentral.getChildren().addAll(lblPesquisa, lblID, txtID, lblGenero, txtGenero, lblTitulo, txtTitulo,
                lblSubtitulo, txtSubtitulo, lblAutor, txtAutor, lblEditora, txtEditora, lblSinopse, txtSinopse,
                lblISBN, txtISBN, lblEdicao, txtEdicao, lblAno, txtAno);

        layoutOrganizacao.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral);

        return layoutOrganizacao;
    }
}
