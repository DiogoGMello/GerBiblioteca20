package boundery;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.bean.Emprestimo;

public class TelaInicio{

    TableView<Emprestimo> table;

    public Scene geraInicioScene(){
        Scene scnInicio = new Scene(geraInicioNode(), 750, 600);
        return scnInicio;
    }

    public VBox geraInicioNode(){

        //Set para a coluna Nome
        // Este determina o cabeçalho e o que vai naquela coluna
        TableColumn<Emprestimo, String> nomeColuna = new TableColumn<>("Nome");
        //Determina o tamanho minimo da coluna a ser exibido na tabela
        nomeColuna.setMinWidth(200);
        //o string deve ser o mesmo do nome da varial, este determina onde irá buscar a informação
        nomeColuna.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Set para a coluna de Preços
        TableColumn<Emprestimo, Double> precoColuna = new TableColumn<>("Preço");
        precoColuna.setMinWidth(100);
        precoColuna.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Set para a coluna de quantidade
        TableColumn<Emprestimo, Integer> quantColuna = new TableColumn<>("Qtde");
        quantColuna.setMinWidth(200);
        quantColuna.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().addAll(nomeColuna, precoColuna, quantColuna);


        //Layout
        VBox layout = new VBox(20);
        layout.getChildren().addAll(table);

        return layout;
    }

    public ObservableList<Emprestimo> getProducts(){
        ObservableList<Emprestimo> emprestimo = FXCollections.observableArrayList();
        emprestimo.addAll();
        return emprestimo;
    }
}
