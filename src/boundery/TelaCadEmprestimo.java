package boundery;

import controller.ClienteCtr;
import controller.EmprestimoCtr;
import controller.ExemplaresCtr;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.bean.Cliente;
import model.bean.Emprestimo;
import model.bean.Exemplar;
import model.bean.Livro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadEmprestimo {

    Label lblPesquisa, lblPesqID, lblPesqCliente, lblCadastro, lblID, lblDtEmprestimo, lblStatus, lblCliente,
            lblClienteID, lblClienteCPF, lblDevPrevista, lblDevEfetiva, lblExemplarTitulo, lblExemplarSubTitulo,
            lblExemplarID, lblNumClienteID, lblNumExemplarID, lblGuia;

    static TextField txtPesqID, txtPesqCliente, txtID, txtDtEmprestimo, txtStatus, txtCliente, txtClienteID,
            txtClienteCPF, txtDevPrevista, txtDevEfetiva, txtExemplarTitulo, txtExemplarSubTitulo, txtExemplarID;

    Button btnPesquiar, btnPesqCliente, btnPesqExemplar;

    Exemplar exemplarTela = new Exemplar();
    ExemplaresCtr exemplaresCtr = new ExemplaresCtr();

    Cliente clienteTela = new Cliente();
    ClienteCtr clienteCtr = new ClienteCtr();

    Emprestimo emprestimo = new Emprestimo();
    EmprestimoCtr emprestimoCtr = new EmprestimoCtr();

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

        lblPesqCliente = new Label("Cliente");
        txtPesqCliente = new TextField();

        btnPesquiar = new Button("Search");
        btnPesquiar.setOnAction(e->{
                emprestimo = emprestimoCtr.pesqCtrlEmprestimo(pesqEmprestimo());
                setTelaEmprestimo(emprestimo);
        });

        layoutPesquisa.getChildren().addAll(lblPesqCliente, txtPesqCliente, btnPesquiar);

        //Campos de cadastro
        lblCadastro = new Label("CADASTRO");



        lblID = new Label("ID");
        layoutCentral.setConstraints(lblID, 0, 1);
        txtID = new TextField();
        layoutCentral.setConstraints(txtID, 1,1);
        lblDtEmprestimo = new Label("Data Emprestimo");
        layoutCentral.setConstraints(lblDtEmprestimo, 2, 1);
        txtDtEmprestimo = new TextField();
        layoutCentral.setConstraints(txtDtEmprestimo, 3,1);
        lblStatus = new Label("Status");
        layoutCentral.setConstraints(lblStatus, 4, 1);
        txtStatus = new TextField();
        txtStatus.setText("ANDAMENTO");
        layoutCentral.setConstraints(txtStatus, 5,1);




        lblCliente = new Label("Cliente Nome");
        layoutCentral.setConstraints(lblCliente, 0, 2);
        txtCliente = new TextField();
        layoutCentral.setConstraints(txtCliente, 1,2);
        lblClienteCPF = new Label("CPF");
        layoutCentral.setConstraints(lblClienteCPF, 2, 2);
        txtClienteCPF = new TextField();
        layoutCentral.setConstraints(txtClienteCPF, 3, 2);
        lblClienteID = new Label("Cliente ID");
        layoutCentral.setConstraints(lblClienteID, 4, 2);
        lblNumClienteID = new Label("NAO SELECIONADO");
        lblNumClienteID.setStyle("-fx-background-color: white;");
        layoutCentral.setConstraints(lblNumClienteID, 5,2);

        btnPesqCliente = new Button("Pesq Cliente");
        btnPesqCliente.minWidth(300);
        layoutCentral.setConstraints(btnPesqCliente,1, 3);
        btnPesqCliente.setOnAction(e->{
            clienteTela = clienteCtr.pesqCtrlCliente(pesqClienteEmprestimo());
            txtCliente.setText(clienteTela.getNome());
            txtClienteCPF.setText(clienteTela.getCpf());
            lblNumClienteID.setText(Integer.toString(clienteTela.getIdCliente()));
        });

        lblDevPrevista = new Label("Dev Prevista");
        layoutCentral.setConstraints(lblDevPrevista, 0, 4);
        txtDevPrevista = new TextField();
        layoutCentral.setConstraints(txtDevPrevista, 1,4);
        lblDevEfetiva = new Label("Dev Efetiva");
        layoutCentral.setConstraints(lblDevEfetiva, 2, 4);
        txtDevEfetiva = new TextField();
        layoutCentral.setConstraints(txtDevEfetiva, 3,4);

        lblExemplarTitulo = new Label("Exemplar Titulo");
        layoutCentral.setConstraints(lblExemplarTitulo, 0, 5);
        txtExemplarTitulo = new TextField();
        layoutCentral.setConstraints(txtExemplarTitulo, 1,5);
        lblExemplarSubTitulo = new Label("Exemplar SubTitulo");
        layoutCentral.setConstraints(lblExemplarSubTitulo, 2, 5);
        txtExemplarSubTitulo = new TextField();
        layoutCentral.setConstraints(txtExemplarSubTitulo, 3,5);
        lblExemplarID = new Label("Exemplar ID");
        layoutCentral.setConstraints(lblExemplarID, 4, 5);
        lblNumExemplarID = new Label("NAO SELECIONADO");
        lblNumExemplarID.setStyle("-fx-background-color: white;");
        layoutCentral.setConstraints(lblNumExemplarID, 5,5);

        btnPesqExemplar = new Button("Pesquisar Exemplar");
        btnPesqExemplar.minWidth(200);
        layoutCentral.setConstraints(btnPesqExemplar, 1,6);
        btnPesqExemplar.setOnAction(e->{
            exemplarTela = exemplaresCtr.pesqCtrlExemplar(pesqExemplarEmprestimo());
            txtExemplarTitulo.setText(exemplarTela.getLivro().getTitulo());
            txtExemplarSubTitulo.setText(exemplarTela.getLivro().getSubTitulo());
            lblNumExemplarID.setText(Integer.toString(exemplarTela.getIdExemplar()));
        });

        layoutCentral.getChildren().addAll(
                lblID, txtID, lblDtEmprestimo, txtDtEmprestimo, lblStatus, txtStatus,
                lblCliente, txtCliente, lblClienteCPF, txtClienteCPF, lblClienteID, lblNumClienteID,
                btnPesqCliente,
                lblDevPrevista, txtDevPrevista, lblDevEfetiva, txtDevEfetiva,
                lblExemplarTitulo, txtExemplarTitulo, lblExemplarSubTitulo, txtExemplarSubTitulo, lblExemplarID,
                lblNumExemplarID, btnPesqExemplar);

        layoutPrincipal.getChildren().addAll(lblPesquisa, layoutPesquisa, lblCadastro, layoutCentral);

        return layoutPrincipal;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Emprestimo coletaEmprestimo(){

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setCliente(clienteTela);
        emprestimo.setExemplar(exemplarTela);

        if(txtStatus.getText() == "FINALIZADO"){
            emprestimo.setStatusEmprestimo(false);
        }else{
            emprestimo.setStatusEmprestimo(true);
        }

        try{
            Date formatDate = sdf.parse(txtDtEmprestimo.getText());
            emprestimo.setDataEmprestimo(formatDate);
            formatDate = sdf.parse(txtDevEfetiva.getText());
            emprestimo.setDataDevEfetiva(formatDate);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return emprestimo;
    }

    public Emprestimo colEditaEmprestimo(){
        Emprestimo emprestimo = new Emprestimo();

        emprestimo = coletaEmprestimo();
        emprestimo.setIdEmprestimo(Integer.parseInt(txtID.getText()));

        return emprestimo;
    }

    public void setTelaEmprestimo(Emprestimo emprestimo){

        Date dataFormat;
        String dataString;

        txtPesqCliente.setText("");
        txtPesqID.setText("");

        txtID.setText(Integer.toString(emprestimo.getIdEmprestimo()));

        dataFormat = emprestimo.getDataEmprestimo();
        dataString = dataFormat.toString();
        txtDtEmprestimo.setText(dataString);

        if(emprestimo.isStatusEmprestimo() == true) {
            txtStatus.setText("ANDAMENTO");
        }else{
            txtStatus.setText("FINALIZADO");
        }
        txtCliente.setText(emprestimo.getCliente().getNome());
        txtClienteCPF.setText(emprestimo.getCliente().getCpf());
        lblNumClienteID.setText(Integer.toString(emprestimo.getCliente().getIdCliente()));

        dataFormat = emprestimo.getDataDevEfetiva();
        dataString = dataFormat.toString();
        txtDevEfetiva.setText(dataString);

        txtExemplarTitulo.setText(emprestimo.getExemplar().getLivro().getTitulo());
        txtExemplarSubTitulo.setText(emprestimo.getExemplar().getLivro().getSubTitulo());
        lblNumExemplarID.setText(Integer.toString(emprestimo.getExemplar().getIdExemplar()));
    }

    public void restartCrudEmprestimo(){

        txtPesqCliente.setText("");
        txtPesqID.setText("");
        txtID.setText("");
        txtDtEmprestimo.setText("");
        txtStatus.setText("Andamento");
        txtCliente.setText("");
        txtClienteCPF.setText("");
        lblNumClienteID.setText("NAO SELECIONADO");
        txtDevPrevista.setText("");
        txtDevEfetiva.setText("");
        txtExemplarTitulo.setText("");
        txtExemplarSubTitulo.setText("");
        lblNumExemplarID.setText("NAO SELECIONADO");

    }

    public String pesqEmprestimo(){

        return txtPesqCliente.getText();

    }

    public Cliente pesqClienteEmprestimo(){
        Cliente cliente = new Cliente();

        cliente.setNome(txtCliente.getText());
        cliente.setCpf(txtClienteCPF.getText());

        return cliente;
    }

    public Livro pesqExemplarEmprestimo(){
        Livro livro = new Livro();

        livro.setTitulo(txtExemplarTitulo.getText());
        livro.setSubTitulo(txtExemplarSubTitulo.getText());

        return livro;
    }
}
