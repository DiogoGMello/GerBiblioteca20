package model.dao;

import connection.ConnectionFactory;
import model.bean.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {

    private Connection con = null;
    Autor autor = new Autor();

    public AutorDao(){
        con = ConnectionFactory.getConnection();
    }

    //ir� inserir um novo campo no banco de dados
    public boolean salvarAutorBD(Autor autor){

        String sql = "INSERT INTO autor () VALUES ()";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, autor.());
//            stmt.setString(2, autor.());
//            stmt.setString(3, autor.());

            stmt.executeUpdate();

            return true;

        }catch (SQLException ex){

            System.err.println("Erro: " + ex);

            return false;
        }finally{

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    //Ir� atualizar o registro do autor
    public boolean alterarAutorBD(Autor autor){

        String sql = "UPDATE autor SET nome = ?, endereco = ?, telefone = ? WHERE cliente_ID = ?";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, autor.());
//            stmt.setString(2, autor.());
//            stmt.setString(3, autor.e());
//            stmt.setInt(4, autor.());

            return true;

        }catch(SQLException ex){

            System.err.println("Error: "+ex);
            return false;

        }finally{

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Buscar todos os registros de autor da tabela
    public List<Autor> encontrarAutorBDTodos(){

        String sql = "SELECT * FROM autor";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Autor> autor = new ArrayList<>();

        return autor;
    }

    public Autor encontrarAutorID(int id) {
        String sql = "SELECT * FROM cliente ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Autor autor = new Autor();
        return autor;
    }
}

