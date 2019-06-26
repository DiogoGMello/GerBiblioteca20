package boundery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import model.bean.Emprestimo;
import model.dao.EmprestimoDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TelaInicio {

    TableView<Emprestimo> table;


    public VBox telaInicio(){

        //Set para a coluna Nome
        // Este determina o cabeçalho e o que vai naquela coluna
        TableColumn<Emprestimo, Integer> idColuna = new TableColumn<>("ID");
        //Determina o tamanho minimo da coluna a ser exibido na tabela
        idColuna.setMinWidth(15);
        //o string deve ser o mesmo do nome da varial, este determina onde irá buscar a informação
        idColuna.setCellValueFactory(new PropertyValueFactory<>("idEmprestimo"));

        TableColumn<Emprestimo, Date> dataEmprestimo = new TableColumn<>("Data Emprestimo");
        dataEmprestimo.setMinWidth(200);
        dataEmprestimo.setCellValueFactory(new PropertyValueFactory<>("dataEmprestimo"));

        TableColumn<Emprestimo, Date> dataDevPrevista = new TableColumn<>("Devolução Prevista");
        dataDevPrevista.setMinWidth(200);
        dataDevPrevista.setCellValueFactory(new PropertyValueFactory<>("dataDevPrevista"));

        TableColumn<Emprestimo, Date> dataDevReal = new TableColumn<>("Devolução Real");
        dataDevReal.setMinWidth(200);
        dataDevReal.setCellValueFactory(new PropertyValueFactory<>("dataDevEfetiva"));

        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().addAll(idColuna, dataEmprestimo, dataDevPrevista, dataDevReal);


        VBox layout = new VBox(20);
        layout.getChildren().addAll(table);

        return  layout;
    }

    public ObservableList<Emprestimo> getProducts(){
        ObservableList<Emprestimo> emprestimoTela = FXCollections.observableArrayList();

        EmprestimoDao emprestimoDao = new EmprestimoDao();
        List<Emprestimo> listaEmprestimo = new ArrayList<>();

        for (Emprestimo emprestimo : listaEmprestimo) {
            emprestimoTela.add(emprestimo);
        }

        return emprestimoTela;
    }

    public int itemSelecionadoId(){
        int id;

        ObservableList<Emprestimo> produtoSelecionado;

        Emprestimo emprestimo = table.getSelectionModel().getSelectedItem();

        id = emprestimo.getIdEmprestimo();

        return id;
    }

}
