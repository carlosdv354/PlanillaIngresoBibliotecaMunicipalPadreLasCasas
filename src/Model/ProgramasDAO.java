package Model;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ProgramasDAO {
    //instancia de coneccion
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public List<Programas> listProgramas(){
        List<Programas> lista_progamas = new ArrayList();
        String query = "SELECT id, nombre FROM programas";
        
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Programas programa = new Programas();
                programa.setId(rs.getString("id"));
                programa.setNombre(rs.getString("nombre"));
                lista_progamas.add(programa);
            }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR " +e.getMessage());
        }
        return lista_progamas;
    }
}
