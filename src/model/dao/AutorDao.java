package model.dao;

import auxiliares.AuxiliaresData;
import connection.ConnectionFactory;
import model.bean.Autor;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class AutorDao {

    public Autor createAutorBD(Autor autor) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String query = null;

        try {

            if (autor.getIdAutor() > 0) {
                query = "UPDATE autores set nome=?, pais_origem=?, especialidade=? WHERE id=?";
                stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(4, autor.getIdAutor());

            } else {
                query = "INSERT INTO autores (pais_origem, nome, especialidade, data_criacao, status) VALUES (?,?,?,?,?)";
                stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                autor.setDataCriacao(Date.valueOf(LocalDate.now()));
                autor.setStatus(true);
                stmt.setDate(4, (Date) autor.getDataCriacao());
                stmt.setBoolean(5, autor.getStatus());
            }

            stmt.setString(1, autor.getPaisOrigem());
            stmt.setString(2, autor.getNomeoAutor());
            stmt.setString(3, autor.getEspecialidade());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                autor.setIdAutor(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return autor;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return autor;
    }

    //irá listar todos os autores na tabela
    public List<Autor> listarAutoresBD(){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Autor> listaAutor = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM autores");
            rs = stmt.executeQuery();

            while (rs.next()){
                Autor autor = new Autor();

                autor.setIdAutor(rs.getInt("id"));
                autor.setPaisOrigem(rs.getString("pais_origem"));
                autor.setNomeAutor(rs.getString("nome"));
                autor.setEspecialidade(rs.getString("especialidade"));

                listaAutor.add(autor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaAutor;
    }

    //irá pesquisar um unico autor
    public Autor pesquisaAutorBD(String nome){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Autor autor = new Autor();

        try {
            stmt = con.prepareStatement("SELECT * FROM autores WHERE nome = ?");

            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            if (rs.next()) {
                autor.setIdAutor(rs.getInt("id"));
                autor.setPaisOrigem(rs.getString("pais_origem"));
                autor.setNomeAutor(rs.getString("nome"));
                autor.setEspecialidade(rs.getString("especialidade"));
                autor.setDataCriacao(rs.getDate("data_criacao"));
                autor.setStatus(rs.getBoolean("status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return autor;
    }

}

