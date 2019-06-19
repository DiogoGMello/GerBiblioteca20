package boundery;

import controller.BtnLateralControler;
import controller.LoginCtr;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.bean.Usuario;
import principal.MainBiblioteca;
import sun.plugin2.util.ColorUtil;

import java.awt.*;

public class TelaLogin{

    Label labelTitulo, labelUser, labelPass, labelAlert;
    static TextField txtUser;
    static PasswordField txtPass;
    Button btnLogin;

    LoginCtr loginCtr = new LoginCtr();

    public BorderPane geraTelaLogin(String alert){

        Usuario usuario = new Usuario();

        BorderPane layoutReturn = new BorderPane();
        GridPane layoutGrid = new GridPane();
        layoutGrid.setPadding(new Insets(20));
        layoutGrid.setVgap(20);
        layoutGrid.setHgap(10);
        BtnLateralControler btnLateralControler = new BtnLateralControler();

        labelAlert = new Label(alert);
        layoutGrid.setConstraints(labelAlert, 1, 3);

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
            usuario.setUsuario(txtUser.getText());
            usuario.setSenha(txtPass.getText());
            loginCtr.checaLoginFixo(usuario);
            //MainBiblioteca.scnPrincipal.setRoot(btnLateralControler.crudCliente());
        });

        layoutGrid.getChildren().addAll(labelTitulo, labelUser, txtUser, labelPass, txtPass, btnLogin, labelAlert);
        layoutReturn.setCenter(layoutGrid);

        return layoutReturn;
    }

//    public Usuario coletaUsuario(){
//        Usuario usuario = new Usuario();
//
//        usuario.setUsuario(txtUser.getText());
//        usuario.setSenha(txtPass.getText());
//
//        return usuario;
//    }
}
