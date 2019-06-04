package boundery;

import controller.BtnInferioresCtr;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BotoesInferiores {

    Button btnSalvar, btnNovo, btnDeletar, btnVerificar;

    public HBox botoesCRUD(){

        HBox layoutBotoes = new HBox(15);
        BtnInferioresCtr btnInferioresCtrl = new BtnInferioresCtr();
        btnNovo = new Button("Novo");
        btnNovo.setMinWidth(100);
        btnNovo.setOnAction(e->{
            btnInferioresCtrl.funcaoNovo();
        });
        btnDeletar = new Button("Deletar");
        btnDeletar.setMinWidth(100);
        btnDeletar.setOnAction(e->{
            btnInferioresCtrl.funcaoDeletar();
        });
        btnSalvar = new Button("Salvar");
        btnSalvar.setMinWidth(100);
        btnSalvar.setOnAction(e-> {
            btnInferioresCtrl.funcaoSalvar();
        });

        layoutBotoes.getChildren().addAll(btnNovo, btnDeletar, btnSalvar);
        layoutBotoes.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        return layoutBotoes;
    }

    public HBox botaoInicial(){

        HBox layoutBotoes = new HBox();

        btnNovo = new Button("Verificar Selecionado");
        btnNovo.setMinWidth(100);

        layoutBotoes.getChildren().addAll(btnVerificar);
        layoutBotoes.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        return layoutBotoes;
    }
}
