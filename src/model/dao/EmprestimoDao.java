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

        String sql = "SELECT * FROM emprestimo";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Emprestimo> emprestimo = new ArrayList<>();

        return emprestimo;
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
//
//        ExemplarDao exemplarDao = new ExemplarDao();
//        Exemplar exemplar = new Exemplar();
//        ClienteDao clienteDao = new ClienteDao();
//        Cliente cliente = new Cliente();
//
//        try {
//            stmt = con.prepareStatement("SELECT * FROM emprestimo WHERE id = ?");
//            stmt.setInt(1, id);
//            rs = stmt.executeQuery();
//
//
//            emprestimo.setIdEmprestimo(rs.getInt("id"));
//            emprestimo.setDataEmprestimo(rs.getDate("data_emprestimo"));
//            emprestimo.setDataDevEfetiva(rs.getDate("data_devolucao_efetiva"));
//            emprestimo.setDataDevPrevista(rs.getDate("data_devolucao_prevista"));
//
//            //coleta o cliente
//            cliente = clienteDao.pesquisaClienteIdBD(rs.getString("id_cliente"));
//            emprestimo.setCliente(cliente);
//
//            //coleta o livro e inclui no exemplar
//            exemplar = exemplarDao.pesquisaExemplarIdBD(rs.getInt("id_exemplar"));
//            emprestimo.setExemplar(exemplar);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            ConnectionFactory.closeConnection(con, stmt, rs);
//        }

        return emprestimo;
    }
}

