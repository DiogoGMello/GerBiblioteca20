package model.dao;

import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Funcionario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    //irá inserir um novo campo no banco de dados
    public Funcionario createOrUpdateFuncionario(Funcionario funcionario) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String query = null;

        try {
            if (funcionario.getIdFuncionario() > 0) {
                query = "UPDATE funcionarios SET cpf=?, nome=?, endereco=?, numero=?, complemento=?, bairro=?, cep=?, cidade=?, estado=? WHERE id=?";
                stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(10, funcionario.getIdFuncionario());
            } else {
                query = "INSERT INTO funcionarios (cpf, nome, endereco, numero, complemento, bairro, cep, cidade, estado, data_criacao, status) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                funcionario.setDataInicioContrato(Date.valueOf(LocalDate.now()));
                stmt.setDate(10, (Date) funcionario.getDataInicioContrato());
                funcionario.setStatus(true);
                stmt.setBoolean(11, funcionario.getStatus());
            }

            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getNumeroEndereco());
            stmt.setString(5, "null");
            stmt.setString(6, funcionario.getBairro());
            stmt.setString(7, funcionario.getCep());
            stmt.setString(8, funcionario.getCidade());
            stmt.setString(9, funcionario.getEstado());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                funcionario.setIdFuncionario(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return funcionario;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return funcionario;
    }

    //irá listar todos os clientes na tabela
    public List<Funcionario> listarFuncionarioBD(){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> listaFuncionario = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcinarios");
            rs = stmt.executeQuery();

            while (rs.next()){
                Funcionario funcionario = new Funcionario();

                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNumeroEndereco(rs.getString("numero"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setEstado(rs.getString("estado"));
                funcionario.setIdFuncionario(rs.getInt("id"));

                listaFuncionario.add(funcionario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaFuncionario;
    }

    //irá pesquisar um unico cliente Nome
    public Funcionario pesquisaFuncionarioBD(Funcionario funcionario){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionarioInt = new Funcionario();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios  WHERE nome=? or cpf=?");

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            rs = stmt.executeQuery();

            if (rs.next()) {
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNumeroEndereco(rs.getString("numero"));
                funcionario.setComplemento(rs.getString("complemento"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setEstado(rs.getString("estado"));
                funcionario.setIdFuncionario(rs.getInt("id"));
                funcionario.setDataInicioContrato(rs.getDate("data_criacao"));
                funcionario.setStatus(rs.getBoolean("status"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return funcionario;
    }

    //irá pesquisar um unico cliente por cpf
    public Funcionario pesquisaFuncionarioCPFBD(int cpf){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios  WHERE cpf = ?");

            stmt.setInt(1, cpf);
            rs = stmt.executeQuery();

            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setEndereco(rs.getString("endereco"));
            funcionario.setNumeroEndereco(rs.getString("numero"));
            funcionario.setBairro(rs.getString("bairro"));
            funcionario.setCep(rs.getString("cep"));
            funcionario.setCidade(rs.getString("cidade"));
            funcionario.setEstado(rs.getString("estado"));
            funcionario.setIdFuncionario(rs.getInt("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionario;
    }
}

