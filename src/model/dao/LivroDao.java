package model.dao;

import connection.ConnectionFactory;
import model.bean.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {

    private Connection con = null;

    public LivroDao(){
        con = ConnectionFactory.getConnection();
    }

    //ir� inserir um novo campo no banco de dados
    public boolean salvarLivroBD(Livro livro){

        String sql = "INSERT INTO livro () VALUES ()";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, livro.());
//            stmt.setString(2, livro.());
//            stmt.setString(3, livro.());

            stmt.executeUpdate();

            return true;

        }catch (SQLException ex){

            System.err.println("Erro: " + ex);

            return false;
        }finally{

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    //Ir� atualizar o registro do livro
    public boolean alterarLivroBD(Livro livro){

        String sql = "UPDATE livro SET nome = ?, endereco = ?, telefone = ? WHERE cliente_ID = ?";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, livro.());
//            stmt.setString(2, livro.());
//            stmt.setString(3, livro.e());
//            stmt.setInt(4, livro.());

            return true;

        }catch(SQLException ex){

            System.err.println("Error: "+ex);
            return false;

        }finally{

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Buscar todos os registros de livro da tabela
    public List<Livro> encontrarLivroBDTodos(){

        String sql = "SELECT * FROM livro";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Livro> livro = new ArrayList<>();

        return livro;
    }

    public Livro encontrarLivroID(int id) {
        String sql = "SELECT * FROM livro ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Livro livro = new Livro();
        return livro;
    }
}

