package boundery;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MoldePrincipal extends Application {

    Stage window;
    Scene scnMenuLateral;
    Label tituloPagina;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("GerBiblioteca");

        BorderPane layoutPrincipal = new BorderPane();
        MenuLateral menu = new MenuLateral();

        layoutPrincipal.setLeft(menu.menuMontagem());

        scnMenuLateral = new Scene(layoutPrincipal, 400, 400);

        window.setScene(scnMenuLateral);
        window.show();

    }
}
