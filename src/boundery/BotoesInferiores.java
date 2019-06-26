package boundery;

import controller.BtnInferioresCtr;
import controller.BtnLateralControler;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import model.bean.Emprestimo;
import model.dao.EmprestimoDao;

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
        BtnLateralControler btnLateralControler = new BtnLateralControler();
        EmprestimoDao emprestimoDao = new EmprestimoDao();
        TelaInicio telaInicio = new TelaInicio();
        TelaCadEmprestimo telaCadEmprestimo = new TelaCadEmprestimo();

        btnVerificar = new Button("Verificar Selecionado");
        btnVerificar.setMinWidth(100);
        btnVerificar.setOnAction(e->{
            Emprestimo emprestimo =
                    emprestimoDao.pesquisaEmprestimoIdBD(
                            telaInicio.itemSelecionadoId());
            btnLateralControler.crudEmprestimo();
            telaCadEmprestimo.setTelaEmprestimo(emprestimo);
        });

        layoutBotoes.getChildren().addAll(btnVerificar);
        layoutBotoes.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        return layoutBotoes;
    }
}
