package model.dao;

import connection.ConnectionFactory;
import model.bean.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {

    private Connection con = null;

    public AutorDao(){
        con = ConnectionFactory.getConnection();
    }

    //ir� inserir um novo campo no banco de dados
    public boolean salvarClienteBD(Cliente cliente){

        String sql = "INSERT INTO cliente () VALUES ()";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, cliente.());
//            stmt.setString(2, cliente.());
//            stmt.setString(3, cliente.());

            stmt.executeUpdate();

            return true;

        }catch (SQLException ex){

            System.err.println("Erro: " + ex);

            return false;
        }finally{

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    //Ir� atualizar o registro do cliente
    public boolean alterarClienteBD(Cliente cliente){

        String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ? WHERE cliente_ID = ?";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, cliente.());
//            stmt.setString(2, cliente.());
//            stmt.setString(3, cliente.e());
//            stmt.setInt(4, cliente.());

            return true;

        }catch(SQLException ex){

            System.err.println("Error: "+ex);
            return false;

        }finally{

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Buscar todos os registros de cliente da tabela
    public List<Cliente> encontrarClienteBDTodos(){

        String sql = "SELECT * FROM cliente";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> cliente = new ArrayList<>();

        return cliente;
    }

    public Cliente encontrarClienteID(int id) {
        String sql = "SELECT * FROM cliente ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Cliente cliente = new Cliente();
        return cliente;
    }
}

