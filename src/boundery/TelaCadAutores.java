package boundery;

import controller.AutorCtr;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.bean.Autor;

public class TelaCadAutores{

    Label lblPesquisa, lblPesqNome, lblCadastro, lblID, lblPaisOrigem, lblNome, lblEspecialidade;
    static Label txtID;
    static TextField txtPesqNome, txtPaisOrigem, txtNome, txtEspecialidade;
    static Button btnPesquiar;

    public VBox geraCrudAutores(){

        AutorCtr autorController = new AutorCtr();

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
        lblPesquisa = new Label("PESQUISA AUTORES");

        lblPesqNome = new Label("Nome");
        txtPesqNome = new TextField();
        btnPesquiar = new Button("Search");
        btnPesquiar.setOnAction(e-> {
            autorController.pesqCtlrAutor(pesqAutor());
        });

        layoutPesquisa.getChildren().addAll(lblPesqNome, txtPesqNome, btnPesquiar);

        //Campos de cadastro
        lblCadastro = new Label("CADASTRO AUTORES");

        lblID = new Label("ID");
        layoutCentral.setConstraints(lblID, 0, 0);
        txtID = new Label("0");
        layoutCentral.setConstraints(txtID, 1,0);

        lblPaisOrigem = new Label("Pais de Origem");
        layoutCentral.setConstraints(lblPaisOrigem, 0, 1);
        txtPaisOrigem = new TextField();
        layoutCentral.setConstraints(txtPaisOrigem, 1,1);

        lblNome = new Label("Nome");
        layoutCentral.setConstraints(lblNome, 0, 2);
        txtNome = new TextField();
        layoutCentral.setConstraints(txtNome, 1,2);

        lblEspecialidade = new Label("Especialidade");
        layoutCentral.setConstraints(lblEspecialidade, 0, 3);
        txtEspecialidade = new TextField();
        layoutCentral.setConstraints(txtEspecialidade, 1,3);

        layoutCentral.getChildren().addAll(lblID, txtID, lblPaisOrigem, txtPaisOrigem, lblNome, txtNome,
                lblEspecialidade, txtEspecialidade);

        layoutPrincipal.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral);

        return layoutPrincipal;
    }

    public Autor coletaAutor(){
        Autor autor = new Autor();

        autor.setIdAutor(Integer.parseInt(txtID.getText()));
        autor.setNomeAutor(txtNome.getText());
        autor.setPaisOrigem(txtPaisOrigem.getText());
        autor.setEspecialidade(txtEspecialidade.getText());

        return autor;
    }

    public void setTelaAutor(Autor autor){

        txtPesqNome.setText("");
        txtID.setText(Integer.toString(autor.getIdAutor()));
        txtNome.setText(autor.getNomeoAutor());
        txtEspecialidade.setText(autor.getEspecialidade());
        txtPaisOrigem.setText(autor.getPaisOrigem());
    }

    public void restartCrud(){

        txtPesqNome.setText("");
        txtID.setText("0");
        txtNome.setText("");
        txtEspecialidade.setText("");
        txtPaisOrigem.setText("");

    }

    public String pesqAutor(){
        return txtPesqNome.getText();
    }
}
