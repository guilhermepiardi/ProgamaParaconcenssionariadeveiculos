package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import DTO.CadastroCarroMotoDTO;

public class CadastroCarroMotoDAO {

    Connection conn;
    PreparedStatement pstm;

    public void cadastroCarroMoto(CadastroCarroMotoDTO cadastroCarroMoto) {
        String sql = "call inserirveiculo(?,?,?,?,?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cadastroCarroMoto.getVeiculo());
            pstm.setString(2, cadastroCarroMoto.getMarca());
            pstm.setString(3, cadastroCarroMoto.getModelo());
            pstm.setString(4, cadastroCarroMoto.getCor());
            pstm.setString(5, cadastroCarroMoto.getAno());
            pstm.setDouble(6, cadastroCarroMoto.getValor_pago());
            pstm.setString(7, cadastroCarroMoto.getDescricao());
            pstm.setString(8, cadastroCarroMoto.getPlaca());
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null,"Veiculo Cadastrado Com Sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CadastroCarroMotoDAO " + e);
        }

    }

}
