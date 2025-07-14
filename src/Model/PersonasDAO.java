package Model;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class PersonasDAO {

    //instancia de coneccion
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public boolean registerPersonas(Personas persona) {
        String query = "INSERT INTO Personas (nombre, rut, telefono, id_programa, fecha) VALUES (?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getRut());
            pst.setString(3, persona.getTelefono());
            pst.setString(4, persona.getId_programa());
            pst.setTimestamp(5, datetime);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
            return false;
        }
    }

    public List listPersonas() {
        List<Personas> Lista_personas = new ArrayList();
        String query = "SELECT per.nombre, per.rut, per.telefono, pro.nombre AS programa, per.fecha FROM personas per JOIN programas pro ON per.id_programa = pro.id";

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Personas persona = new Personas();
                persona.setNombre(rs.getString("Nombre"));
                persona.setRut(rs.getString("Rut"));
                persona.setTelefono(rs.getString("Telefono"));
                persona.setNombre_progama(rs.getString("Programa"));
                Date fechaBD = rs.getDate("fecha");
                String FormatoFecha = "";
                if (fechaBD != null) {
                    FormatoFecha = new SimpleDateFormat("MMMM dd").format(fechaBD);
                }
                persona.setFecha(FormatoFecha);
                Lista_personas.add(persona);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
        }
        return Lista_personas;
    }
}
