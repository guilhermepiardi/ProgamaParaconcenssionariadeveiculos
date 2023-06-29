package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO login) {

        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "select * from usuarios where usuario =? and senha = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, login.getUsuario());
            pstm.setString(2, login.getSenha());
            ResultSet rs = pstm.executeQuery();
            
            return rs;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "UsuarioDAO" + e);
            return null;
        }
        
    }

}
