package model.dao;

import connection.ConnectionFactory;
import model.bean.Emprestimo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao {

    private Connection con = null;

    public EmprestimoDao(){
        //con = ConnectionFactory.getConnection();
    }

    //ir� inserir um novo campo no banco de dados
    public boolean salvarEmprestimoBD(Emprestimo emprestmo){

        String sql = "INSERT INTO emprestimo () VALUES ()";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, emprestimo.());
//            stmt.setString(2, emprestimo.());
//            stmt.setString(3, emprestimo.());

            stmt.executeUpdate();

            return true;

        }catch (SQLException ex){

            System.err.println("Erro: " + ex);

            return false;
        }finally{

            //ConnectionFactory.closeConnection(con, stmt);

        }
    }

    //Ir� atualizar o registro do emprestimo
    public boolean alterarEmprestimoBD(Emprestimo emprestimo){

        String sql = "UPDATE emprestimo SET nome = ?, endereco = ?, telefone = ? WHERE cliente_ID = ?";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, emprestimo.());
//            stmt.setString(2, emprestimo.());
//            stmt.setString(3, emprestimo.e());
//            stmt.setInt(4, emprestimo.());

            return true;

        }catch(SQLException ex){

            System.err.println("Error: "+ex);
            return false;

        }finally{

            //ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Buscar todos os registros de emprestimo da tabela
    public List<Emprestimo> encontrarEmprestimoBDTodos(){

        String sql = "SELECT * FROM emprestimo";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Emprestimo> emprestimo = new ArrayList<>();

        return emprestimo;
    }

    public Emprestimo encontrarEmprestimoID(int id) {
        String sql = "SELECT * FROM emprestimo ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Emprestimo emprestimo = new Emprestimo();
        return emprestimo;
    }
}

