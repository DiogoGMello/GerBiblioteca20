package boundery;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TelaCadEmprestimo {

    Label lblPesquisa, lblPesqID, lblPesqCliente, lblCadastro, lblID, lblDtEmprestimo, lblStatus, lblCliente, lblDevPrevista,
            lblDevEfetiva, lblExemlar01, lblExemlar02, lblExemlar03;
    TextField txtPesqID, txtPesqCliente, txtID, txtDtEmprestimo, txtStatus, txtCliente, txtDevPrevista,
            txtDevEfetiva, txtExemlar01, txtExemlar02, txtExemlar03;
    Button btnPesquiar;

    public VBox geraCrudEmprestimo(){

        GridPane layoutCentral = new GridPane();
        layoutCentral.setPadding(new Insets(10));
        layoutCentral.setVgap(15);
        layoutCentral.setHgap(15);
        layoutCentral.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        VBox layoutPrincipal = new VBox(10);
        layoutPrincipal.setPadding(new Insets(10));

        HBox layoutPesquisa = new HBox(15);
        layoutPesquisa.setPadding(new Insets(10));
        layoutPesquisa.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        //Campos Pesquisa
        lblPesquisa = new Label("PESQUISA");

        lblPesqID = new Label("ID");
        txtPesqID = new TextField();
        lblPesqCliente = new Label("Cliente");
        txtPesqCliente = new TextField();
        btnPesquiar = new Button("Search");

        layoutPesquisa.getChildren().addAll(lblPesqID, txtPesqID, lblPesqCliente, txtPesqCliente, btnPesquiar);

        //Campos de cadastro
        lblCadastro = new Label("CADASTRO");

        lblID = new Label("ID");
        layoutCentral.setConstraints(lblID, 0, 0);
        txtID = new TextField();
        layoutCentral.setConstraints(txtID, 1,0);
        lblDtEmprestimo = new Label("Data Emprestimo");
        layoutCentral.setConstraints(lblDtEmprestimo, 2, 0);
        txtDtEmprestimo = new TextField();
        layoutCentral.setConstraints(txtDtEmprestimo, 3,0);
        lblStatus = new Label("Status");
        layoutCentral.setConstraints(lblStatus, 4, 0);
        txtStatus = new TextField();
        layoutCentral.setConstraints(txtStatus, 5,0);

        lblCliente = new Label("Cliente");
        layoutCentral.setConstraints(lblCliente, 0, 1);
        txtCliente = new TextField();
        layoutCentral.setConstraints(txtCliente, 1,1);

        lblDevPrevista = new Label("Dev Prevista");
        layoutCentral.setConstraints(lblDevPrevista, 0, 2);
        txtDevPrevista = new TextField();
        layoutCentral.setConstraints(txtDevPrevista, 1,2);
        lblDevEfetiva = new Label("Dev Efetiva");
        layoutCentral.setConstraints(lblDevEfetiva, 2, 2);
        txtDevEfetiva = new TextField();
        layoutCentral.setConstraints(txtDevEfetiva, 3,2);

        lblExemlar01 = new Label("Exemplar 01");
        layoutCentral.setConstraints(lblExemlar01, 0, 3);
        txtExemlar01 = new TextField();
        layoutCentral.setConstraints(txtExemlar01, 1,3);

        layoutCentral.getChildren().addAll(lblPesquisa, lblID, txtID, lblDtEmprestimo, txtDtEmprestimo, lblStatus,
                txtStatus, lblCliente, txtCliente, lblDevPrevista, txtDevPrevista, lblDevEfetiva, txtDevEfetiva,
                lblExemlar01, txtExemlar01);

        layoutPrincipal.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral);

        return layoutPrincipal;
    }
}
