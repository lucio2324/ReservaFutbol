package EntidadDAO;

import conexioBD.Conexion;
import entidades.Cancha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class canchaDAO {
    
    public String InsertarCancha (Cancha c){
    
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="INSERT INTO `cancha`( `nombre_cancha`, `id_club`) VALUES (?, ?);";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1, c.getNombre());
            prs.setString(2, c.getId_club());
            prs.execute();
           return "ok";
           // con.desconectar();
           
        } catch (SQLException ex) {
        return "false"+ex;
    }
        
        
          
}
}