package model.dao;

import connection.ConnectionFactory;
import model.bean.Autor;
import model.bean.Editora;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EditoraDao {

    //irá inserir um novo campo no banco de dados
    public Editora createEditoraBD(Editora editora) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String query = null;

        try {

            if (editora.getIdEditora() > 0) {
                query = "UPDATE editoras set nome=?, revendedor=?, contato_revendedor=?, email_editora=?, email_revendedor=?, contato=? WHERE id=?";
                stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(7, editora.getIdEditora());
            } else {
                query = "INSERT INTO editoras (nome, revendedor, contato_revendedor, email_editora, email_revendedor, contato, data_criacao, status) VALUES (?,?,?,?,?,?,?,?)";
                stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                editora.setDataCriacao(Date.valueOf(LocalDate.now()));
                editora.setStatus(true);
                stmt.setDate(7, (Date) editora.getDataCriacao());
                stmt.setBoolean(8, editora.getStatus());
            }

            stmt.setString(1, editora.getNome());
            stmt.setString(2, editora.getRevendedor());
            stmt.setString(3, editora.getContatoRevendedor());
            stmt.setString(4, editora.getEmail());
            stmt.setString(5, editora.getEmailRevendedor());
            stmt.setString(6, editora.getContato());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                editora.setIdEditora(rs.getInt(1));
            }

            return editora;

        } catch (SQLException e) {
            e.printStackTrace();
            return editora;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //irá atualizar um dado na tabela autores
    public Editora updateEditoraBD(Editora editora){

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;


        try {
            stmt = con.prepareStatement(
                    "UPDATE editora SET nome = ? , revendedor = ?, contato_revendedor = ?, " +
                            "email_editora = ?, email_revendedor = ?, contato = ? WHERE id = ?");

            stmt.setString(1, editora.getNome());
            stmt.setString(2, editora.getRevendedor());
            stmt.setString(3, editora.getContatoRevendedor());
            stmt.setString(4, editora.getEmail());
            stmt.setString(5, editora.getEmailRevendedor());
            stmt.setString(6, editora.getContato());
            stmt.setInt(7, editora.getIdEditora());

            stmt.executeUpdate();

            return editora;

        } catch (SQLException e) {
            e.printStackTrace();
            return editora;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //irá listar todos os editoras na tabela
    public List<Editora> listarEditorasBD(){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Editora> listaEditora = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM editoras");
            rs = stmt.executeQuery();

            while (rs.next()){
                Editora editora = new Editora();

                editora.setNome(rs.getString("nome"));
                editora.setRevendedor(rs.getString("revendedor"));
                editora.setContatoRevendedor(rs.getString("contato_revendedor"));
                editora.setEmail(rs.getString("email_editora"));
                editora.setEmailRevendedor(rs.getString("email_revendedor"));
                editora.setContato(rs.getString("contato"));
                editora.setIdEditora(rs.getInt("id"));

                listaEditora.add(editora);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaEditora;
    }

    //irá pesquisar um unico editora
    public Editora pesquisaEditoraBD(String nome){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Editora editora = new Editora();

        try {
            stmt = con.prepareStatement("SELECT * FROM editoras WHERE nome = ?");

            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            if (rs.next()) {
                editora.setNome(rs.getString("nome"));
                editora.setRevendedor(rs.getString("revendedor"));
                editora.setContatoRevendedor(rs.getString("contato_revendedor"));
                editora.setEmail(rs.getString("email_editora"));
                editora.setEmailRevendedor(rs.getString("email_revendedor"));
                editora.setContato(rs.getString("contato"));
                editora.setIdEditora(rs.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return editora;
    }
}

