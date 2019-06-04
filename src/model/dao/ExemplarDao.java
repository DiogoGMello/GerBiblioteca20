package model.dao;

import connection.ConnectionFactory;
import model.bean.Exemplar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExemplarDao {

    private Connection con = null;

    public ExemplarDao(){
        con = ConnectionFactory.getConnection();
    }

    //ir� inserir um novo campo no banco de dados
    public boolean salvarExemplarBD(Exemplar exemplar){

        String sql = "INSERT INTO exemplar () VALUES ()";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, exemplar.());
//            stmt.setString(2, exemplar.());
//            stmt.setString(3, exemplar.());

            stmt.executeUpdate();

            return true;

        }catch (SQLException ex){

            System.err.println("Erro: " + ex);

            return false;
        }finally{

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    //Ir� atualizar o registro do exemplar
    public boolean alterarExemplarBD(Exemplar exemplar){

        String sql = "UPDATE exemplar SET nome = ?, endereco = ?, telefone = ? WHERE cliente_ID = ?";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, exemplar.());
//            stmt.setString(2, exemplar.());
//            stmt.setString(3, exemplar.e());
//            stmt.setInt(4, exemplar.());

            return true;

        }catch(SQLException ex){

            System.err.println("Error: "+ex);
            return false;

        }finally{

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Buscar todos os registros de exemplar da tabela
    public List<Exemplar> encontrarExemplarBDTodos(){

        String sql = "SELECT * FROM cliente";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Exemplar> exemplar = new ArrayList<>();

        return exemplar;
    }

    public Exemplar encontrarExemplarID(int id) {
        String sql = "SELECT * FROM cliente ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Exemplar exemplar = new Exemplar();
        return exemplar;
    }
}

