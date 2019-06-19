package model.dao;

import connection.ConnectionFactory;
import model.bean.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    public Usuario login(String login, String senha) throws SQLException
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * from usuarios WHERE usuario = ? and senha = ?");
        ResultSet rs = null;
        Usuario usuario = new Usuario();

        try {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setStatus(rs.getBoolean("status"));
                usuario.setDataCriacao(rs.getDate("data_criacao"));
                usuario.setMaster(rs.getBoolean("is_usuario_master"));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return usuario;
    }

}
