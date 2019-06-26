package model.dao;

import connection.ConnectionFactory;
import model.bean.Emprestimo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao {

    private Connection con = null;

    public EmprestimoDao(){
        //con = ConnectionFactory.getConnection();
    }

    public Emprestimo createOrUpdateEmprestimoBD(Emprestimo emprestimo){

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String query = null;

        Date dataSQLEmprestimo, dataSQLPrevista, dataSQLEfetiva;

        try {

            if (emprestimo.getIdEmprestimo() > 0) {
                stmt = con.prepareStatement(
                        "UPDATE emprestimos SET data_emprestimo = ?, id_cliente = ?, id_exemplar = ?, " +
                "data_devolucao_efetiva = ?, data_devolucao_prevista = ? WHERE id = ?");
                stmt.setInt(6, emprestimo.getIdEmprestimo());

            } else {
                stmt = con.prepareStatement(
                        "INSERT INTO emprestimos (data_emprestimo,id_cliente, id_exemplar, " +
                                "data_devolucao_efetiva, data_devolucao_prevista)"
                                + " VALUES (?,?,?,?,?)");

            }


            stmt.setDate(1, Date.valueOf(LocalDate.now()));
            stmt.setInt(2, emprestimo.getIdCliente());
            stmt.setInt(3, emprestimo.getIdExemplar());
           // dataSQLEfetiva = new Date(emprestimo.getDataDevEfetiva().getTime());
            stmt.setDate(4, Date.valueOf(LocalDate.now()));
            //dataSQLPrevista = new Date(emprestimo.getDataDevPrevista().getTime());
            stmt.setDate(5, Date.valueOf(LocalDate.now()));

            stmt.executeUpdate();
            return emprestimo;

        } catch (SQLException e) {
            e.printStackTrace();
            return emprestimo;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
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
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Emprestimo> listaEmprestimo = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM emprestimos");
            rs = stmt.executeQuery();

            while (rs.next()){
                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setIdEmprestimo(rs.getInt("id"));
                emprestimo.setDataEmprestimo(rs.getDate("data_emprestimo"));
                emprestimo.setDataDevPrevista(rs.getDate("data_devolucao_efetiva"));
                emprestimo.setDataDevEfetiva(rs.getDate("data_devolucao_prevista"));

                listaEmprestimo.add(emprestimo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaEmprestimo;
    }

    public Emprestimo encontrarEmprestimoID(int id) {
        String sql = "SELECT * FROM emprestimo ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Emprestimo emprestimo = new Emprestimo();
        return emprestimo;
    }

    public Emprestimo pesquisaEmprestimoIdBD(int id){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Emprestimo emprestimo = new Emprestimo();

        String query = "SELECT " +

                "em.id, " +
                "em.data_devolucao_efetiva, " +
                "em.data_devolucao_prevista, " +
                "em.data_emprestimo, " +
                "em.status, " +
                "ex.id as id_exemplar, " +
                "cl.id as id_livro" +
                "cl.nome, " +
                "cl.cpf, " +
                "li.titulo, " +
                "li.subtitulo " +
                "FROM emprestimos em " +
                "INNER JOIN clientes cl on cl.id = em.id_cliente " +
                "INNER JOIN exemplares ex on ex.id = em.id_exemplar " +
                "INNER JOIN livros li on li.id = ex.id_livro " +
                "WHERE em.id=?";

        try {
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if(rs.next()) {
                emprestimo.setIdEmprestimo(rs.getInt("id"));
                emprestimo.setDataEmprestimo(rs.getDate("data_emprestimo"));
                emprestimo.setDataDevEfetiva(rs.getDate("data_devolucao_efetiva"));
                emprestimo.setDataDevPrevista(rs.getDate("data_devolucao_prevista"));
                emprestimo.setIdExemplar(rs.getInt("id_exemplar"));
                emprestimo.setIdCliente(rs.getInt("id_cliente"));
                emprestimo.setNomeCliente(rs.getString("nome"));
                emprestimo.setTituloLivro(rs.getString("titulo"));
                emprestimo.setSubtituoLivro(rs.getString("subtitulo"));
                emprestimo.setStatusEmprestimo(rs.getBoolean("status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return emprestimo;
    }
}

