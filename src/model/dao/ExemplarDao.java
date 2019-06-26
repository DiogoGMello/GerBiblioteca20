package model.dao;

import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Emprestimo;
import model.bean.Exemplar;
import model.bean.Livro;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExemplarDao {

    public Exemplar insertOrupdateExemplarBD(Exemplar exemplar){

        Connection con = ConnectionFactory.getConnection();
        String query = null;
        PreparedStatement stmt = null;


        try {
            if (exemplar.getIdExemplar() > 0) {
                query = "UPDATE exemplares set id_livro=?, n_serie=?, condicao=?, data_remocao=? WHERE id=?";
                stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(5, exemplar.getIdExemplar());
            } else {
                query = "INSERT INTO exemplares(id_livro, n_serie, condicao, data_remocao, data_aquisicao) VALUE(?,?,?,?,?)";
                stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stmt.setDate(5, Date.valueOf(LocalDate.now()));
            }

            stmt.setInt(1, exemplar.getLivro().getIdLivro());
            stmt.setString(2, exemplar.getNumSerie());
            stmt.setString(3, exemplar.getConservacao());
            stmt.setDate(4, (Date) exemplar.getDataRemocao());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                exemplar.setIdExemplar(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return exemplar;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return exemplar;

    }

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
                exemplar.setNumSerie(rs.getString("n_serie"));
                exemplar.setConservacao(rs.getString("condicao"));
                exemplar.setDataEntrada(rs.getDate("data_aquisicao"));
                exemplar.setIdExemplar(rs.getInt("id"));
                exemplar.setStatus(rs.getBoolean("status"));

                listaExemplares.add(exemplar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaExemplares;
    }

    public Exemplar pesquisaExemplarBD(Livro livro){
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT e.id, e.id_livro, l.titulo, l.subtitulo, e.n_serie, e.condicao, e.status, e.data_aquisicao, e.data_remocao FROM exemplares e INNER JOIN livros l ON l.id = e.id_livro WHERE l.titulo=? OR l.subtitulo=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Exemplar exemplarInt = new Exemplar();
        Livro livroInt = new Livro();

        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getSubTitulo());

            rs = stmt.executeQuery();

            if (rs.next()) {
                exemplarInt.setIdExemplar(rs.getInt("id"));
                exemplarInt.setNumSerie(rs.getString("n_serie"));
                exemplarInt.setConservacao(rs.getString("condicao"));
                exemplarInt.setDataEntrada(rs.getDate("data_aquisicao"));
                exemplarInt.setDataRemocao(rs.getDate("data_remocao"));

                livroInt.setIdLivro(rs.getInt("id_livro"));
                livroInt.setTitulo(rs.getString("titulo"));
                livroInt.setSubTitulo(rs.getString("subtitulo"));

                exemplarInt.setLivro(livroInt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return exemplarInt;

    }

    public Exemplar pesquisaExemplarIdBD(int id){
        //Autor autor = new Autor();
        Livro livro = new Livro();
        LivroDao livroDao = new LivroDao();
        Exemplar exemplar = new Exemplar();
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM exemplares WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            exemplar.setLivro(livro);
            exemplar.setIdExemplar(rs.getInt("id"));
            exemplar.setDataEntrada(rs.getDate("data_aquisicao"));
            exemplar.setConservacao(rs.getString("condicao"));
            exemplar.setStatusExemplar(rs.getBoolean("status"));
            exemplar.setNumSerie(rs.getString("n_serie"));

            //Pesquisa livros para incluir no exemplar
            livro = livroDao.pesquisaLivroIdBD(rs.getInt("id_livro"));
            exemplar.setLivro(livro);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return exemplar;
    }

    public Emprestimo pesquisaEmprestimoIdBD(int id){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Emprestimo emprestimo = new Emprestimo();

        ExemplarDao exemplarDao = new ExemplarDao();
        Exemplar exemplar = new Exemplar();
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();

        try {
            stmt = con.prepareStatement("SELECT * FROM emprestimo WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();


            emprestimo.setIdEmprestimo(rs.getInt("id"));
            emprestimo.setDataEmprestimo(rs.getDate("data_emprestimo"));
            emprestimo.setDataDevEfetiva(rs.getDate("data_devolucao_efetiva"));
            emprestimo.setDataDevPrevista(rs.getDate("data_devolucao_prevista"));

            //coleta o cliente
            cliente = clienteDao.pesquisaClienteIdBD(rs.getInt("id_cliente"));
            emprestimo.setCliente(cliente);

            //coleta o livro e inclui no exemplar
            exemplar = exemplarDao.pesquisaExemplarIdBD(rs.getInt("id_exemplar"));
            emprestimo.setExemplar(exemplar);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return emprestimo;
    }
}

