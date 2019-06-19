package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://mysql.surecorp.com.br:3306/surecorp04";
    private static final String USER = "surecorp04";
    private static final String PASS = "1a2s3d4f";

    //Abre a conexão com o banco de dados
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao conectar: ", ex);
        }
    }

    //Encerra a conexão com o banco de dados
    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: "+ ex);
            }
        }
    }

    //
    public static void closeConnection(Connection con, PreparedStatement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: "+ ex);
            }
        }
        closeConnection(con);
    }

    public static void closeConnection(Connection con,
                                       PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: "+ ex);
            }
        }
        closeConnection(con, stmt);
    }
}