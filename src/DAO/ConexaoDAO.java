
package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class ConexaoDAO {
   
    public  Connection conectaBD(){
      Connection conn = null;
      
      
        try {
            String url= "jdbc:mysql://localhost:3306/concenssionaria?user=root&password=1234";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + e.getMessage());
        
        }
        return conn;
    
 
    }
}