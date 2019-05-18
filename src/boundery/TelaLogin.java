package boundery;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaLogin extends Application {

    Stage window;
    Scene scn;
    Label labelTitulo, labelUser, labelPass;
    TextField txtUser;
    PasswordField txtPass;
    Button btnLogin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("GerBiblioteca 2.0");

        GridPane layoutGrid = new GridPane();
        layoutGrid.setPadding(new Insets(100,45,20,30));
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

        layoutGrid.getChildren().addAll(labelTitulo, labelUser, txtUser, labelPass, txtPass, btnLogin);

        scn = new Scene(layoutGrid, 450, 350);
        window.setScene(scn);
        window.show();
    }
}
