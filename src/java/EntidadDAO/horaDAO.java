package EntidadDAO;

import conexioBD.Conexion;
import entidades.hora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class horaDAO {
    
    public int insertarHora(hora h){
    int id=0;
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="INSERT INTO `hora` (`hora_hora`, `disponible_hora`) VALUES (?,?)";
        try {
            prs = reg.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            prs.setString(1, h.getHora_hora());
            prs.setString(2, h.getDisponible_hora());
            prs.execute();
           ResultSet idGenerado = prs.getGeneratedKeys();
           con.desconectar();
          
            if (idGenerado.next()) {
                id = idGenerado.getInt(1);
            }
           return id;
        } catch (SQLException ex) {
            Logger.getLogger(fechaDAO.class.getName()).log(Level.SEVERE, null, ex);
        return id;
    }
  }
}