package boundery;

import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BotoesInferiores {

    Button btnSalvar, btnNovo, btnLimpar, btnVerificar;

    public HBox botoesCRUD(){

        HBox layoutBotoes = new HBox(15);

        btnNovo = new Button("Novo");
        btnNovo.setMinWidth(100);
        btnLimpar = new Button("Limpar");
        btnLimpar.setMinWidth(100);
        btnSalvar = new Button("Salvar");
        btnSalvar.setMinWidth(100);

        layoutBotoes.getChildren().addAll(btnNovo, btnLimpar, btnSalvar);
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
