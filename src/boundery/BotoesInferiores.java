package boundery;

import controller.BtnInferioresCtr;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.text.ParseException;

public class BotoesInferiores {

    Button btnSalvar, btnLimpar, btnEditar, btnVerificar;

    public HBox botoesCRUD(){

        HBox layoutBotoes = new HBox(15);
        BtnInferioresCtr btnInferioresCtrl = new BtnInferioresCtr();
        btnLimpar = new Button("Limpar");
        btnLimpar.setMinWidth(100);
        btnLimpar.setOnAction(e->{
            btnInferioresCtrl.funcaoLimpar();
        });

        //btnEditar = new Button("Editar");
        //btnEditar.setMinWidth(100);
//        btnEditar.setOnAction(e->{
//            try {
//                btnInferioresCtrl.funcaoEditar();
//            } catch (ParseException ex) {
//                ex.printStackTrace();
//            }
//        });

        btnSalvar = new Button("Salvar");
        btnSalvar.setMinWidth(100);
        btnSalvar.setOnAction(e-> {
            try {
                btnInferioresCtrl.funcaoSalvar();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        });

        layoutBotoes.getChildren().addAll(btnLimpar, btnSalvar);
        layoutBotoes.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        return layoutBotoes;
    }

    public HBox botaoInicial(){

        HBox layoutBotoes = new HBox();

        btnLimpar = new Button("Verificar Selecionado");
        btnLimpar.setMinWidth(100);

        layoutBotoes.getChildren().addAll(btnVerificar);
        layoutBotoes.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        return layoutBotoes;
    }
}
