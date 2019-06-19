package model.dao;

import connection.ConnectionFactory;
import model.bean.Editora;
import model.bean.Livro;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {
    //irá inserir um novo campo no banco de dados
    public Livro createOrUpdateLivroBD(Livro livro) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            if (livro.getIdLivro() > 0) {
                System.out.println("vai editar");
                stmt = con.prepareStatement(
                        "UPDATE livros SET titulo=?, subtitulo=?, autor=?, sinopse=?, genero=?, editora=?, isbn=?, edicao=?, ano=? WHERE id =?",
                        Statement.RETURN_GENERATED_KEYS
                );
                stmt.setInt(10, livro.getIdLivro());

            } else {
                System.out.println("vai salvar");
                stmt = con.prepareStatement(
                        "INSERT INTO livros (titulo, subtitulo, autor, sinopse, genero, editora, isbn, edicao, ano, data_cadastro, status)"
                                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS
                );
                stmt.setDate(10, Date.valueOf(LocalDate.now()));
                stmt.setInt(11, 1);
            }

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getSubTitulo());
            stmt.setString(3, livro.getAutor());
            stmt.setString(4, livro.getSinopse());
            stmt.setString(5, livro.getGenero());
            stmt.setString(6, livro.getEditora());
            stmt.setString(7, livro.getISBN());
            stmt.setString(8, livro.getEdicao());
            stmt.setString(9, livro.getAno());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()) {
                livro.setIdLivro(rs.getInt(1));
            }

            return livro;

        } catch (SQLException e) {
            e.printStackTrace();
            return livro;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //irá listar todos os autores na tabela
    public List<Livro> listarAutoresBD(){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Livro> listaLivros = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM livros");
            rs = stmt.executeQuery();

            while (rs.next()){
                Livro livro = new Livro();
            //    Autor autor = new Autor();
                Editora editora = new Editora();

                livro.setTitulo(rs.getString("titulo"));
                livro.setSubTitulo(rs.getString("subtitulo"));
                //Precisa verificar como faz que eu não sei
                //livro.setAutor(autor.setIdAutor(rs.getInt("autor")));
                livro.setSinopse(rs.getString("sinopse"));
                livro.setGenero(rs.getString("genero"));
                //O mesmo para a editora
                //livro.setEditora(editora.setIdEditora(rs.getInt("editora")));
                livro.setISBN(rs.getString("isbn"));
                livro.setAno(rs.getString("ano"));
                livro.setIdLivro(rs.getInt("id"));

                listaLivros.add(livro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaLivros;
    }

    //irá pesquisar um unico autor
    public Livro pesquisaLivroBD(String titulo, String subtitulo)
    {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Livro livro = new Livro();

        try {
            stmt = con.prepareStatement("SELECT * FROM livros WHERE titulo = ? or subtitulo = ?");

            stmt.setString(1, titulo);
            stmt.setString(2, subtitulo);
            rs = stmt.executeQuery();

            if(rs.next()) {
                livro.setTitulo(rs.getString("titulo"));
                livro.setSubTitulo(rs.getString("subtitulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setSinopse(rs.getString("sinopse"));
                livro.setEditora(rs.getString("editora"));
                livro.setEdicao(rs.getString("edicao"));
                livro.setGenero(rs.getString("genero"));
                livro.setISBN(rs.getString("isbn"));
                livro.setAno(rs.getString("ano"));
                livro.setIdLivro(rs.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return livro;
    }


}

