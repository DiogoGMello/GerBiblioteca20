package model.dao;

import connection.ConnectionFactory;
import model.bean.Exemplar;
import model.bean.Livro;

import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExemplarDao {
    //irá inserir um novo campo no banco de dados

//    public Exemplar createExemplarBD(Exemplar exemplar) {
//
//        LivroDao livroDao = new LivroDao();
//        Livro livro = new Livro();
//
//        livro = livroDao.pesquisaLivroTituloBD(exemplar.getLivro());
//
//        Connection con = ConnectionFactory.getConnection();
//
//        PreparedStatement stmt = null;
//
//
//        try {
//            stmt = con.prepareStatement(
//                    "INSERT INTO exemplares (id_livro, n_serie, condicao, data_aquisicao)"
//                            + " VALUES (?,?,?,?,?)");
//
//            stmt.setInt(1, livro.getIdLivro());
//            stmt.setInt(2, exemplar.getNumSerie());
//            stmt.setString(3, exemplar.getConservacao());
//            //stmt.setDate(4, exemplar.getDataEntrada());
//
//            stmt.executeUpdate();
//            return exemplar;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return exemplar;
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt);
//        }
//    }

    //irá atualizar um dado na tabela autores
    public Exemplar updateExemplarBD(Exemplar exemplar){

        Connection con = ConnectionFactory.getConnection();


        PreparedStatement stmt = null;


        try {
            stmt = con.prepareStatement(
                    "UPDATE exemplares SET id_livro = ?, n_serie = ?, condicao = ?, data_aquisicao = ? " +
                            "WHERE id = ?");

            stmt.setInt(1, exemplar.getLivro().getIdLivro());
            stmt.setInt(2, exemplar.getNumSerie());
            stmt.setString(3, exemplar.getConservacao());
            //stmt.setDate(4, exemplar.getDataEntrada());
            stmt.setInt(5, exemplar.getIdExemplar());

            stmt.executeUpdate();

            return exemplar;

        } catch (SQLException e) {
            e.printStackTrace();
            return exemplar;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //irá listar todos os autores na tabela
    public List<Exemplar> listarExemplaresBD(){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Exemplar> listaExemplares = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM livros");
            rs = stmt.executeQuery();

            while (rs.next()){
                Exemplar exemplar = new Exemplar();

                //exemplar.setLivro(rs.getString("id_livro"));
                exemplar.setNumSerie(rs.getInt("n_serie"));
                exemplar.setConservacao(rs.getString("condicao"));
                exemplar.setDataEntrada(rs.getDate("data_aquisicao"));
                exemplar.setIdExemplar(rs.getInt("id"));

                listaExemplares.add(exemplar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaExemplares;
    }

    //irá pesquisar um unico autor
//    public void Exemplar pesquisaExemplarBD(){
//        Connection con = ConnectionFactory.getConnection();
//
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Autor autor = new Autor();
//        Livro livro = new Livro();
//        LivroDao livroDao = new LivroDao();
//
//    }
}

