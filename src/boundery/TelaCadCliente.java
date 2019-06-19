package boundery;

import controller.ClienteCtr;
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
import model.bean.Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadCliente{

    Label lblPesquisa, lblPesqNome, lblPesqCPF, lblCadastro, lblID, lblCPF, lblNome, lblEndereco, lblNumero,
            lblBairro, lblCEP, lblCidade, lblEstado;
    static Label txtID;
    static TextField txtPesqNome, txtPesqCPF, txtCPF, txtNome, txtEndereco, txtNumero, txtBairro, txtCEP,
            txtCidade, txtEstado;
    Button btnPesquiar;

    static ClienteCtr clienteCtr = new ClienteCtr();

    public VBox geraCrudCliente(){

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

        lblPesqNome = new Label("Nome");
        txtPesqNome = new TextField();
        lblPesqCPF = new Label("CPF");
        txtPesqCPF = new TextField();
        btnPesquiar = new Button("Search");

        btnPesquiar.setOnAction(e -> {
            clienteCtr.pesqCtrlCliente(colPesqCliente());
        });

        layoutPesquisa.getChildren().addAll(lblPesqNome, txtPesqNome, lblPesqCPF, txtPesqCPF, btnPesquiar);

        //Campos de cadastro
        lblCadastro = new Label("CADASTRO");

        lblID = new Label("ID");
        layoutCentral.setConstraints(lblID, 0, 0);
        txtID = new Label();
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

//        lblDtCadastro = new Label("Data Cadastro");
//        layoutCentral.setConstraints(lblDtCadastro, 0, 5);
//        txtDtCadastro = new TextField();
//        layoutCentral.setConstraints(txtDtCadastro, 1,5);
//        lblStatus = new Label("Status");
//        layoutCentral.setConstraints(lblStatus, 2, 5);
//        txtStatus = new TextField();
//        layoutCentral.setConstraints(txtStatus, 3,5);

        layoutCentral.getChildren().addAll(lblPesquisa, lblID, txtID, lblCPF, txtCPF, lblNome, txtNome, lblEndereco,
                txtEndereco, lblNumero, txtNumero, lblBairro, txtBairro, lblCEP, txtCEP, lblCidade, txtCidade,
                lblEstado, txtEstado);

        layoutPrincipal.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral);

        return layoutPrincipal;
    }

    public Cliente coletaCliente(){
        Cliente cliente = new Cliente();

        if (!txtID.getText().isEmpty()) {
            cliente.setIdCliente(Integer.parseInt(txtID.getText()));
        }

        cliente.setCpf(txtCPF.getText());
        cliente.setNome(txtNome.getText());
        cliente.setEndereco(txtEndereco.getText());
        cliente.setNumeroEndereco(txtNumero.getText());
        cliente.setBairro(txtBairro.getText());
        cliente.setCep(txtCEP.getText());
        cliente.setCidade(txtCidade.getText());
        cliente.setEstado(txtEstado.getText());
        return cliente;
    }

    public Cliente colEditaCliente(){
        Cliente cliente = new Cliente();
        cliente = coletaCliente();
        cliente.setIdCliente(Integer.parseInt(txtID.getText()));

        return cliente;
    }

    public void setTelaCliente(Cliente cliente){
        System.out.println(cliente.getNome());

        txtPesqNome.setText("");
        txtPesqCPF.setText("");
        txtID.setText(Integer.toString(cliente.getIdCliente()));
        //txtID.setText();
        txtCPF.setText(cliente.getCpf());
        txtNome.setText(cliente.getNome());
        txtEndereco.setText(cliente.getEndereco());
        txtNumero.setText(cliente.getNumeroEndereco());
        txtBairro.setText(cliente.getBairro());
        txtCEP.setText(cliente.getCep());
        txtCidade.setText(cliente.getCidade());
        txtEstado.setText(cliente.getEstado());

    }

    public void rstartCliente(){
        txtPesqNome.setText("");
        txtPesqCPF.setText("");
        txtID.setText("");
        txtCPF.setText("");
        txtNome.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCEP.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
    }

    public Cliente colPesqCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome(txtPesqNome.getText());
        cliente.setCpf(txtPesqCPF.getText());

        return cliente;
    }

}
