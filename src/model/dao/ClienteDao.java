package model.dao;

import connection.ConnectionFactory;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.bean.Autor;
import model.bean.Cliente;

public class ClienteDao {

    //irá inserir um novo campo no banco de dados
    public Cliente createOrUpdateClienteBD(Cliente cliente) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String insertQuery = "INSERT INTO clientes (cpf, nome, endereco, numero, complemento, bairro, cep, cidade, estado, status, data_criacao)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        String editQuery = "UPDATE clientes SET cpf = ?, nome = ?, endereco = ?, numero = ?, complemento = ?, " +
                "bairro = ?, cep = ?, cidade = ?, estado = ? WHERE id = ?";

        try {

            if (cliente.getIdCliente() > 0) {
                stmt = con.prepareStatement(editQuery);
                stmt.setInt(10, cliente.getIdCliente());
            } else {
                stmt = con.prepareStatement(insertQuery);
                stmt.setInt(10, 1);
                stmt.setDate(11, Date.valueOf(LocalDate.now()));
            }

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getNumeroEndereco());
            stmt.setString(5, cliente.getComplemento());
            stmt.setString(6, cliente.getBairro());
            stmt.setString(7, cliente.getCep());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getEstado());

            stmt.executeUpdate();
            return cliente;

        } catch (SQLException e) {
            e.printStackTrace();
            return cliente;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //irá atualizar um dado na tabela clientes
    public Cliente updateClienteBD(Cliente cliente){

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;


        try {
            stmt = con.prepareStatement(
                    "UPDATE clientes SET cpf = ?, nome = ?, endereco = ?, numero = ?, complemento = ?, " +
                            "bairro = ?, cep = ?, cidade = ?, estado = ? WHERE id = ?");

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getNumeroEndereco());
            stmt.setString(5, cliente.getComplemento());
            stmt.setString(6, cliente.getBairro());
            stmt.setString(7, cliente.getCep());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getEstado());
            stmt.setInt(10, cliente.getIdCliente());

            stmt.executeUpdate();
            return cliente;

        } catch (SQLException e) {
            e.printStackTrace();
            return cliente;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //irá listar todos os clientes na tabela
    public List<Cliente> listarClienteBD(){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> listaCliente = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();

            while (rs.next()){
                Cliente cliente = new Cliente();

                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumeroEndereco(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setIdCliente(rs.getInt("id"));

                listaCliente.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaCliente;
    }

    //irá pesquisar um unico cliente Nome
    public Cliente pesquisaClienteBD(String nome, String cpf) throws SQLException
    {

        System.out.println(nome + " " + cpf);

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM clientes  WHERE nome = ? OR cpf = ?");
        ResultSet rs = null;
        Cliente cliente = new Cliente();

        try {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            rs = stmt.executeQuery();

            if(rs.next()) {
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumeroEndereco(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setIdCliente(rs.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cliente;
    }

    //irá pesquisar um unico cliente por cpf
    public Cliente pesquisaClienteCPFBD(int cpf){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes  WHERE cpf = ?");

            stmt.setInt(1, cpf);
            rs = stmt.executeQuery();

            cliente.setCpf(rs.getString("cpf"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setNumeroEndereco(rs.getString("numero"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setCep(rs.getString("cep"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setEstado(rs.getString("estado"));
            cliente.setIdCliente(rs.getInt("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cliente;
    }

    public Cliente pesquisaClienteIdBD(int id){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes  WHERE id = ?");

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            cliente.setCpf(rs.getString("cpf"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setNumeroEndereco(rs.getString("numero"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setCep(rs.getString("cep"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setEstado(rs.getString("estado"));
            cliente.setIdCliente(rs.getInt("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cliente;
    }

}

