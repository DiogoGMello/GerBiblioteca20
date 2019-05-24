package boundery;

import controller.MenuLateralControler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import principal.MainBiblioteca;

public class TelaLogin{

    Label labelTitulo, labelUser, labelPass;
    TextField txtUser;
    PasswordField txtPass;
    Button btnLogin;

    public BorderPane geraTelaLogin(){

        BorderPane layoutReturn = new BorderPane();
        GridPane layoutGrid = new GridPane();
        layoutGrid.setPadding(new Insets(20));
        layoutGrid.setVgap(20);
        layoutGrid.setHgap(10);

        labelTitulo = new Label("LOGIN");
        layoutGrid.setConstraints(labelTitulo, 1, 0);

        labelUser = new Label("User");
        layoutGrid.setConstraints(labelUser, 0, 1);
        txtUser = new TextField();
        layoutGrid.setConstraints(txtUser, 1, 1);

        labelPass = new Label("Password");
        layoutGrid.setConstraints(labelPass, 0, 2);
        txtPass = new PasswordField();
        layoutGrid.setConstraints(txtPass, 1, 2);

        btnLogin = new Button("Entrar");
        layoutGrid.setConstraints(btnLogin, 2, 2);
        btnLogin.setOnAction( e -> {
            MenuLateralControler menuControler = new MenuLateralControler();
            MainBiblioteca.scnPrincipal.setRoot(menuControler.crudCliente());
        });

        layoutGrid.getChildren().addAll(labelTitulo, labelUser, txtUser, labelPass, txtPass, btnLogin);
        layoutReturn.setCenter(layoutGrid);

        return layoutReturn;
    }
}
