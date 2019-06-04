package model.dao;

import connection.ConnectionFactory;
import model.bean.Editora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditoraDao {

    private Connection con = null;

    public EditoraDao(){
        con = ConnectionFactory.getConnection();
    }

    //ir� inserir um novo campo no banco de dados
    public boolean salvarEditoraBD(Editora editora){

        String sql = "INSERT INTO editora () VALUES ()";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, editora.());
//            stmt.setString(2, editora.());
//            stmt.setString(3, editora.());

            stmt.executeUpdate();

            return true;

        }catch (SQLException ex){

            System.err.println("Erro: " + ex);

            return false;
        }finally{

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    //Ir� atualizar o registro do editora
    public boolean alterarEditoraBD(Editora editora){

        String sql = "UPDATE editora SET nome = ?, endereco = ?, telefone = ? WHERE cliente_ID = ?";

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);

//            stmt.setString(1, editora.());
//            stmt.setString(2, editora.());
//            stmt.setString(3, editora.e());
//            stmt.setInt(4, editora.());

            return true;

        }catch(SQLException ex){

            System.err.println("Error: "+ex);
            return false;

        }finally{

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Buscar todos os registros de editora da tabela
    public List<Editora> encontrarEditoraBDTodos(){

        String sql = "SELECT * FROM editora";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Editora> editoras = new ArrayList<>();

        return editoras;
    }

    public Editora encontrarEditoraID(int id) {
        String sql = "SELECT * FROM editora ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Editora editora = new Editora();
        return editora;
    }
}

