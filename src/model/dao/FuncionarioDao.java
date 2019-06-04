package model.dao;

import connection.ConnectionFactory;
import model.bean.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    private Connection con = null;

    public FuncionarioDao(){
        con = ConnectionFactory.getConnection();
    }

    //ir� inserir um novo campo no banco de dados
    public boolean salvarFuncionarioBD(Funcionario funcionario){

        String sql = "INSERT INTO funcionario () VALUES ()";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, funcionario.());
//            stmt.setString(2, funcionario.());
//            stmt.setString(3, funcionario.());

            stmt.executeUpdate();

            return true;

        }catch (SQLException ex){

            System.err.println("Erro: " + ex);

            return false;
        }finally{

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    //Ir� atualizar o registro do funcionario
    public boolean alterarFuncionarioBD(Funcionario funcionario){

        String sql = "UPDATE funcionario SET nome = ?, endereco = ?, telefone = ? WHERE cliente_ID = ?";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, funcionario.());
//            stmt.setString(2, funcionario.());
//            stmt.setString(3, funcionario.e());
//            stmt.setInt(4, funcionario.());

            return true;

        }catch(SQLException ex){

            System.err.println("Error: "+ex);
            return false;

        }finally{

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Buscar todos os registros de funcionario da tabela
    public List<Funcionario> encontrarFuncionarioBDTodos(){

        String sql = "SELECT * FROM funcionario";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcionario = new ArrayList<>();

        return funcionario;
    }

    public Funcionario encontrarFuncionarioID(int id) {
        String sql = "SELECT * FROM funcionario ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Funcionario funcionario = new Funcionario();
        return funcionario;
    }
}

