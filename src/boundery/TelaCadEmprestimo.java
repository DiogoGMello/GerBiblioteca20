package boundery;

import controller.ClienteCtr;
import controller.ExemplaresCtr;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.bean.Emprestimo;

public class TelaCadEmprestimo {

    Label lblPesquisa, lblPesqID, lblPesqCliente, lblCadastro, lblID, lblDtEmprestimo, lblStatus, lblCliente,
            lblClienteID, lblDevPrevista, lblDevEfetiva, lblExemplar01, lblExemplar01ID, lblExemlar02, lblExemlar03;
    TextField txtPesqID, txtPesqCliente, txtID, txtDtEmprestimo, txtStatus, txtCliente, txtClienteID, txtDevPrevista,
            txtDevEfetiva, txtExemplar01, txtExemplar01ID, txtExemlar02, txtExemlar03;
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
        lblClienteID = new Label("Cliente ID");
        layoutCentral.setConstraints(lblClienteID, 2, 1);
        txtClienteID = new TextField();
        layoutCentral.setConstraints(txtClienteID, 3,1);

        lblDevPrevista = new Label("Dev Prevista");
        layoutCentral.setConstraints(lblDevPrevista, 0, 2);
        txtDevPrevista = new TextField();
        layoutCentral.setConstraints(txtDevPrevista, 1,2);
        lblDevEfetiva = new Label("Dev Efetiva");
        layoutCentral.setConstraints(lblDevEfetiva, 2, 2);
        txtDevEfetiva = new TextField();
        layoutCentral.setConstraints(txtDevEfetiva, 3,2);

        lblExemplar01 = new Label("Exemplar 01");
        layoutCentral.setConstraints(lblExemplar01, 0, 3);
        txtExemplar01 = new TextField();
        layoutCentral.setConstraints(txtExemplar01, 1,3);
        lblExemplar01ID = new Label("Exemplar 01 ID");
        layoutCentral.setConstraints(lblExemplar01ID, 2, 3);
        txtExemplar01ID = new TextField();
        layoutCentral.setConstraints(txtExemplar01ID, 3,3);


        layoutCentral.getChildren().addAll(lblPesquisa, lblID, txtID, lblDtEmprestimo, txtDtEmprestimo, lblStatus,
                txtStatus, lblCliente, txtCliente, lblClienteID, txtClienteID, lblDevPrevista, txtDevPrevista,
                lblDevEfetiva, txtDevEfetiva, lblExemplar01, txtExemplar01, lblExemplar01ID, txtExemplar01ID);

        layoutPrincipal.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral);

        return layoutPrincipal;
    }


    public Emprestimo coletaEmprestimo(){
        Emprestimo emprestimo = new Emprestimo();
        ClienteCtr clienteCtr = new ClienteCtr();
        ExemplaresCtr exemplaresCtr = new ExemplaresCtr();

        emprestimo.setIdEmprestimo(Integer.parseInt(txtID.getText()));
        //Tratar as datas
        //Ajustar
        emprestimo.setStatusEmprestimo(Boolean.parseBoolean(txtStatus.getText()));
        emprestimo.setCliente(clienteCtr.pesqCliente(Integer.parseInt(txtClienteID.getText())));
        emprestimo.setExemplar01(exemplaresCtr.pesqExemplar(Integer.parseInt(txtExemplar01ID.getText())));
        //Tratar datas

        return emprestimo;
    }
}
