package controller;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import boundery.TelaCadCliente;
import model.bean.Cliente;
import model.dao.ClienteDao;

public class ClienteCtr{
    ClienteDao clienteDao = new ClienteDao();
    TelaCadCliente telaCadCliente = new TelaCadCliente();

    public Cliente pesqCtrlCliente(Cliente cliente){

        Cliente clienteInt = new Cliente();

        //Classe DAO para pesquisa por nome
        try {
            clienteInt = clienteDao.pesquisaClienteBD(cliente.getNome(), cliente.getCpf());
            System.out.println(clienteInt.getNome());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        telaCadCliente.setTelaCliente(clienteInt);

        return clienteInt;

    }

    public void salvaCliente(Cliente cliente){
        //classe dao para salvar Cliente novo
        cliente = clienteDao.createOrUpdateClienteBD(cliente);
        System.out.println("Salva o cliente corretamente");
        telaCadCliente.setTelaCliente(cliente);
        System.out.println(cliente);
    }

    public void editaCliente(Cliente cliente){
        //Salva o cliente de acordo com o id
        cliente = clienteDao.updateClienteBD(cliente);
        System.out.println("Edita cliente corretamente");
        telaCadCliente.setTelaCliente(cliente);
        System.out.println(cliente);
    }

    public void limpaCliente(){
        telaCadCliente.rstartCliente();
        System.out.println("Limpa Cliente Ok");
    }
}
