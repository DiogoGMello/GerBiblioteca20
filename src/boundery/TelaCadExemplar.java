package boundery;

import controller.ExemplaresCtr;
import controller.LivrosCtr;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.bean.Exemplar;
import model.bean.Livro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadExemplar{

    Label lblPesquisa, lblPesqTitulo, lblPesqSubtitulo, lblCadastro, lblID, lblTitulo,
            lblSubtitulo, lblNSerie, lblCondicao, lblStatus, lblEmprestimoID, lblDtAquisicao, lblDtRemocao;

    static TextField txtPesqTitulo, txtPesqSubtitulo, txtID, txtTitulo, txtSubtitulo, txtNSerie, txtCondicao,
            txtStatus, txtEmprestimoID, txtDtAquisicao, txtDtRemocao;

    static Livro livro = new Livro();
    static Exemplar exemplar = new Exemplar();

    Button btnPesquisar, btnPesqLivro;

    public VBox geraCrudExemplar(){
        ExemplaresCtr exemplaresCtr = new ExemplaresCtr();
        LivrosCtr livrosCtr = new LivrosCtr();

        GridPane layoutCentral = new GridPane();
        layoutCentral.setPadding(new Insets(10));
        layoutCentral.setVgap(15);
        layoutCentral.setHgap(15);
        layoutCentral.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        VBox layoutPrincipal = new VBox(10);
        layoutPrincipal.setPadding(new Insets(10));

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
        btnPesquisar = new Button("Search Exemplar");
        btnPesquisar.setOnAction(e->{
            exemplar = exemplaresCtr.pesqCtrlExemplar(pesqLivro());
            setTelaExemplar(exemplar);
        });
        btnPesqLivro = new Button("Pesq Teit/Sub Livro");
        btnPesqLivro.setOnAction(e-> {
            livro = livrosCtr.pesqCtrlLivro(pesqLivro());
            setItensLivro(livro);
        });

        layoutPesquisa.getChildren().addAll(lblPesqTitulo, txtPesqTitulo, lblPesqSubtitulo, txtPesqSubtitulo,
                btnPesquisar, btnPesqLivro);

        //Campos de cadastro
        lblCadastro = new Label("CADASTRO");

        lblID = new Label("ID");
        layoutCentral.setConstraints(lblID, 0, 0);
        txtID = new TextField();
        layoutCentral.setConstraints(txtID, 1,0);

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

        layoutCentral.getChildren().addAll(
                lblID, txtID,
                lblTitulo, txtTitulo,
                lblSubtitulo, txtSubtitulo,
                lblNSerie, txtNSerie,
                lblCondicao, txtCondicao,
                lblStatus, txtStatus, lblEmprestimoID, txtEmprestimoID,
                lblDtAquisicao, txtDtAquisicao, lblDtRemocao, txtDtRemocao);

        layoutPrincipal.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral);

        return layoutPrincipal;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Exemplar coletaExemplar() throws ParseException {
        Exemplar exemplar = new Exemplar();
        LivrosCtr livrosCtr = new LivrosCtr();

        exemplar.setLivro(livro);
        exemplar.setNumSerie(Integer.parseInt(txtNSerie.getText()));
        exemplar.setConservacao(txtCondicao.getText());
        exemplar.setStatusExemplar(Boolean.parseBoolean(txtStatus.getText()));
        //Tratar data aquisição e remoção
        try{
            Date formatDate = sdf.parse(txtDtAquisicao.getText());
            exemplar.setDataEntrada(formatDate);

        }catch (ParseException e){
            e.printStackTrace();
        }
        return exemplar;
    }

    public Exemplar colEditarExemplar(){
        Exemplar exemplar = new Exemplar();

        try{
            exemplar = coletaExemplar();
        } catch (ParseException e){
            e.printStackTrace();
        }

        exemplar.setIdExemplar(Integer.parseInt(txtID.getText()));

        return exemplar;
    }

    public void setTelaExemplar(Exemplar exemplar){

        txtPesqTitulo.setText("");
        txtPesqSubtitulo.setText("");
        txtID.setText(Integer.toString(exemplar.getIdExemplar()));
        txtTitulo.setText(exemplar.getLivro().getTitulo());
        txtSubtitulo.setText(exemplar.getLivro().getSubTitulo());
        txtNSerie.setText(Integer.toString(exemplar.getNumSerie()));
        txtCondicao.setText(exemplar.getConservacao());
        txtStatus.setText("");
        txtEmprestimoID.setText("");

        Date dataFormat = exemplar.getDataEntrada();
        String dataString = dataFormat.toString();
        txtDtAquisicao.setText(dataString);

        txtDtRemocao.setText("");
    }

    public void restartCrudExemplar(){

        txtPesqTitulo.setText("");
        txtPesqSubtitulo.setText("");
        txtID.setText("");
        txtTitulo.setText("");
        txtSubtitulo.setText("");
        txtNSerie.setText("");
        txtCondicao.setText("");
        txtStatus.setText("");
        txtEmprestimoID.setText("");
        txtDtAquisicao.setText("");
        txtDtRemocao.setText("");

    }

    public Livro pesqLivro(){

        livro.setTitulo(txtPesqTitulo.getText());
        livro.setSubTitulo(txtPesqSubtitulo.getText());

        return livro;
    }

    void setItensLivro(Livro livro){
        txtTitulo.setText(livro.getTitulo());
        txtSubtitulo.setText(livro.getSubTitulo());
    }
}
