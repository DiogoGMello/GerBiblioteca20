package boundery;

import controller.AutorCtr;
import controller.EditoraCtr;
import controller.LivrosCtr;
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
import model.bean.Livro;

public class TelaCadLivro{

    Label lblPesquisa, lblPesqTitulo, lblPesqSubtitulo, lblCadastro, lblID, lblGenero, lblTitulo,
            lblSubtitulo, lblAutor, lblEditora, lblSinopse, lblISBN, lblEdicao, lblAno;

    static Label txtID;

    static TextField txtPesqTitulo, txtPesqSubtitulo, txtGenero, txtTitulo, txtSubtitulo, txtAutor,
            txtEditora, txtISBN, txtEdicao, txtAno;

    static TextArea txtSinopse;

//    static Autor autorTela = new Autor();
//    static Editora editoraTela = new Editora();

    AutorCtr autorCtr = new AutorCtr();
    EditoraCtr editoraCtr = new EditoraCtr();

    int idAutor, idEditora;

    Button btnPesquiar, btnPesqAutor, btnPesEditora;

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

        LivrosCtr livrosClt = new LivrosCtr();

        //Campos Pesquisa
        lblPesquisa = new Label("PESQUISA");

        lblPesqTitulo = new Label("Titulo");
        txtPesqTitulo = new TextField();
        lblPesqSubtitulo = new Label("Subtitulo");
        txtPesqSubtitulo = new TextField();
        btnPesquiar = new Button("Search");

        layoutPesquisa.getChildren().addAll(lblPesqTitulo, txtPesqTitulo,
                lblPesqSubtitulo, txtPesqSubtitulo, btnPesquiar);

        btnPesquiar.setOnAction(e->{
            livrosClt.pesqCtrlLivro(pesqLivro());
        });

        //Campos de cadastro
        lblCadastro = new Label("CADASTRO");

        lblID = new Label("ID");
        layoutCentral.setConstraints(lblID, 0, 0);
        txtID = new Label("0");
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
        layoutCentral.setConstraints(lblEditora, 0, 4);
        txtEditora = new TextField();
        layoutCentral.setConstraints(txtEditora,1,4);

        lblSinopse = new Label("Sinopse");
        layoutCentral.setConstraints(lblSinopse, 0, 5);
        txtSinopse = new TextArea();
        layoutCentral.setConstraints(txtSinopse, 1,5);

        lblISBN = new Label("ISBN");
        layoutCentral.setConstraints(lblISBN, 0, 6);
        txtISBN = new TextField();
        layoutCentral.setConstraints(txtISBN, 1,6);
        lblAno = new Label("Ano");
        layoutCentral.setConstraints(lblAno, 2, 6);
        txtAno = new TextField();
        layoutCentral.setConstraints(txtAno, 3,6);

        lblEdicao = new Label("Edição");
        layoutCentral.setConstraints(lblEdicao, 0, 7);
        txtEdicao = new TextField();
        layoutCentral.setConstraints(txtEdicao, 1,7);

        layoutCentral.getChildren().addAll(lblPesquisa, lblID, txtID, lblGenero, txtGenero, lblTitulo, txtTitulo,
                lblSubtitulo, txtSubtitulo, lblAutor, txtAutor, lblEditora, txtEditora,
                lblSinopse, txtSinopse, lblISBN, txtISBN, lblEdicao, txtEdicao, lblAno, txtAno);

        layoutOrganizacao.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral);

        return layoutOrganizacao;
    }

    public Livro coletaLivro(){
        Livro livro = new Livro();
        livro.setIdLivro(Integer.parseInt(txtID.getText()));
        livro.setGenero(txtGenero.getText());
        livro.setTitulo(txtTitulo.getText());
        livro.setSubTitulo(txtSubtitulo.getText());
        livro.setAutor(txtAutor.getText());
        livro.setEditora(txtEditora.getText());
        livro.setSinopse(txtSinopse.getText());
        livro.setISBN(txtISBN.getText());
        livro.setEdicao(txtEdicao.getText());
        livro.setAno(txtAno.getText());

        return livro;
    }

    public void setTelaLivro(Livro livro){
        txtPesqTitulo.setText("");
        txtPesqSubtitulo.setText("");
        txtID.setText(Integer.toString(livro.getIdLivro()));
        txtGenero.setText(livro.getGenero());
        txtTitulo.setText(livro.getTitulo());
        txtSubtitulo.setText(livro.getSubTitulo());
        txtAutor.setText(livro.getAutor());
        txtEditora.setText(livro.getEditora());
        txtSinopse.setText(livro.getSinopse());
        txtISBN.setText(livro.getISBN());
        txtAno.setText(livro.getAno());
        txtEdicao.setText(livro.getEdicao());
    }

    public void restartCrudLivro(){
        txtPesqTitulo.setText("");
        txtPesqSubtitulo.setText("");
        txtID.setText("");
        txtGenero.setText("");
        txtTitulo.setText("");
        txtSubtitulo.setText("");
        txtAutor.setText("");
        txtEditora.setText("");
        txtSinopse.setText("");
        txtISBN.setText("");
        txtAno.setText("");
        txtEdicao.setText("");
    }

    public Livro pesqLivro(){
        Livro livro = new Livro();

        livro.setTitulo(txtPesqTitulo.getText());
        livro.setSubTitulo(txtPesqSubtitulo.getText());

        return livro;
    }
}
