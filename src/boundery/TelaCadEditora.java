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
import model.bean.Editora;

public class TelaCadEditora{

    Stage window;

    Label lblPesquisa, lblPesqNome, lblCadastro, lblID, lblNome, lblRevendedor, lblContato, lblContRevendedor,
            lblEmailEditora, lblEmailRevendedor;
    TextField txtPesqNome, txtID, txtNome, txtRevendedor, txtContato, txtContRevendedor,
            txtEmailEditora, txtEmailRevendedor;
    Button btnPesquisar;

    public VBox geraCrudEditora(){
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
        layoutPesquisa.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));

        //Campos Pesquisa
        lblPesquisa = new Label("PESQUISA");

        lblPesqNome = new Label("Nome");
        txtPesqNome = new TextField();
        btnPesquisar = new Button("Search");

        layoutPesquisa.getChildren().addAll(lblPesqNome, txtPesqNome, btnPesquisar);

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

        layoutPrincipal.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral);

        return layoutPrincipal;
    }

    public Editora coletaEditora(){
        Editora editora = new Editora();

        editora.setIdEditora(Integer.parseInt(txtID.getText()));
        editora.setNome(txtNome.getText());
        editora.setRevendedor(txtRevendedor.getText());
        editora.setContato(txtContato.getText());
        editora.setContatoRevendedor(txtContRevendedor.getText());
        editora.setEmail(txtEmailEditora.getText());
        editora.setEmailRevendedor(txtEmailRevendedor.getText());

        return editora;
    }
}
