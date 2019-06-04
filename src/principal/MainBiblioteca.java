package principal;

import boundery.TelaLogin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainBiblioteca extends Application {

    public static Stage window;
    public static Scene scnPrincipal;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("GerBiblioteca 2.0");

        TelaLogin telaLogin = new TelaLogin();

        scnPrincipal = new Scene(telaLogin.geraTelaLogin(), 1000, 550);

        window.setScene(scnPrincipal);
        window.show();
    }
}
