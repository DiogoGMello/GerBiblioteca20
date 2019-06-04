package controller;


import java.util.ArrayList;
import java.util.List;

import boundery.TelaCadCliente;
import model.bean.Cliente;
import model.dao.ClienteDao;

public class ClienteCtr {
    Cliente cliente = new Cliente();
    ClienteDao procCliente = new ClienteDao();
    TelaCadCliente tela = new TelaCadCliente();

    public Cliente pesqClienteNome(String nome) {
        List<Cliente> clientes = new ArrayList();
        clientes = procCliente.encontrarClienteBDTodos();

        for(Cliente busca : clientes) {
            if(busca.getNome() == nome)
                cliente = busca;
        }

        return cliente;
    }

    public void salvaCliente(){

        cliente = tela.coletaCliente();

        procCliente.salvarClienteBD(cliente);
    }

    public Cliente pesqCliente(int id){
        //Cliente cliente = new Cliente();


        //Procedure de pesquisa do cliente atraves do id
        cliente = procCliente.encontrarClienteID(id);

        return cliente;
    }

    public void deletarCliente(int id){


    }
}
