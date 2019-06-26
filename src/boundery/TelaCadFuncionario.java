package boundery;

import controller.FuncionariosCtr;
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
import model.bean.Funcionario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadFuncionario{

    Label lblPesquisa, lblPesqNome, lblPesqCPF, lblCadastro, lblID, lblCPF, lblNome, lblEndereco, lblNumero, lblBairro,
            lblCEP, lblCidade, lblEstado, lblDtCadastro, lblStatus;

    static Label txtID, txtDtCadastro, txtStatus;

    static TextField txtPesqNome, txtPesqCPF, txtCPF, txtNome, txtEndereco, txtNumero, txtBairro, txtCEP,
            txtCidade, txtEstado;
    Button btnPesquisar;

    public VBox geraCrudFuncionarios(){

        FuncionariosCtr funcionariosCtr = new FuncionariosCtr();
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

        lblPesqNome = new Label("Nome");
        txtPesqNome = new TextField();
        lblPesqCPF = new Label("CPF");
        txtPesqCPF = new TextField();
        btnPesquisar = new Button("Search");
        btnPesquisar.setOnAction(e-> funcionariosCtr.pesqCtrlFuncionario(pesqFuncionario()));

        layoutPesquisa.getChildren().addAll(lblPesqNome, txtPesqNome, lblPesqCPF, txtPesqCPF, btnPesquisar);

        //Campos de cadastro
        lblCadastro = new Label("CADASTRO");

        lblID = new Label("ID");
        layoutCentral.setConstraints(lblID, 0, 0);
        txtID = new Label("0");
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
        txtDtCadastro = new Label("");
        layoutCentral.setConstraints(txtDtCadastro, 1,5);
        lblStatus = new Label("Status");
        layoutCentral.setConstraints(lblStatus, 2, 5);
        txtStatus = new Label("");
        layoutCentral.setConstraints(txtStatus, 3,5);

        layoutCentral.getChildren().addAll(lblPesquisa, lblID, txtID, lblCPF, txtCPF, lblNome, txtNome, lblEndereco,
                txtEndereco, lblNumero, txtNumero, lblBairro, txtBairro, lblCEP, txtCEP, lblCidade, txtCidade,
                lblEstado, txtEstado, lblDtCadastro, txtDtCadastro, lblStatus, txtStatus);

        layoutOrganizacao.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral);

        return layoutOrganizacao;
    }

    public Funcionario coletaFuncionario(){
        Funcionario funcionario = new Funcionario();

        funcionario.setIdFuncionario(Integer.parseInt(txtID.getText()));
        funcionario.setCpf(txtCPF.getText());
        funcionario.setNome(txtNome.getText());
        funcionario.setEndereco(txtEndereco.getText());
        funcionario.setNumeroEndereco(txtNumero.getText());
        funcionario.setBairro(txtBairro.getText());
        funcionario.setCep(txtCEP.getText());
        funcionario.setCidade(txtCidade.getText());
        funcionario.setEstado(txtEstado.getText());
        return funcionario;
    }

    public void setTelaFuncionario(Funcionario funcionario){

        txtPesqNome.setText("");
        txtPesqCPF.setText("");
        txtID.setText(Integer.toString(funcionario.getIdFuncionario()));
        txtCPF.setText(funcionario.getCpf());
        txtNome.setText(funcionario.getNome());
        txtEndereco.setText(funcionario.getEndereco());
        txtNumero.setText(funcionario.getNumeroEndereco());
        txtBairro.setText(funcionario.getBairro());
        txtCEP.setText(funcionario.getCep());
        txtCidade.setText(funcionario.getCidade());
        txtEstado.setText(funcionario.getEstado());

        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            txtDtCadastro.setText(dateFormat.format(funcionario.getDataInicioContrato()));
            txtStatus.setText(funcionario.getStatus() ? "Ativo" : "Inativo");
        } catch (Exception e) {

        }


    }

    public void restartCrudFuncionario(){
        txtPesqNome.setText("");
        txtPesqCPF.setText("");
        txtID.setText("0");
        txtCPF.setText("");
        txtNome.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCEP.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
        txtDtCadastro.setText("");
        txtStatus.setText("");
    }

    public Funcionario pesqFuncionario(){
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(txtPesqNome.getText());
        funcionario.setCpf(txtPesqCPF.getText());

        return funcionario;
    }
}
