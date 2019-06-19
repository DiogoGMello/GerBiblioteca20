package controller;

import boundery.TelaLogin;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import model.bean.Usuario;
import model.dao.UsuarioDao;
import principal.MainBiblioteca;
import sun.applet.Main;

import java.sql.SQLException;

public class LoginCtr {

    public static Scene scnPrincipal;

    Boolean validacao = false;
    //UsuarioDao usuarioDao = new UsuarioDao();
    BtnLateralControler btnLateralControler = new BtnLateralControler();

    public void checaLoginFixo(Usuario usuario){
        String pass, user;
        pass = usuario.getSenha();
        user = usuario.getUsuario();

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario returnUsuario = new Usuario();

        try {
            returnUsuario = usuarioDao.login(user, pass);
        } catch(SQLException e) {
            e.printStackTrace();
        }

        if (returnUsuario.getId() > 0) {
            MainBiblioteca.scnPrincipal.setRoot(btnLateralControler.crudCliente());

        } else {
            TelaLogin telaLogin = new TelaLogin();
            BorderPane returnLayout = telaLogin.geraTelaLogin("Usuário ou senha inválidos.");
            MainBiblioteca.scnPrincipal.setRoot(returnLayout);
        }
    }

    public void checaLoginDAO(Usuario usuario){

        //Realiza busca na classe dao enviando o user
        //validacao = usuarioDao.pesqValida(usuario);
        if(validacao == true){
            MainBiblioteca.scnPrincipal.setRoot(btnLateralControler.crudCliente());
        }else{
            System.out.println("PROIBIDA A ENTRADA");
        }
    }
}
