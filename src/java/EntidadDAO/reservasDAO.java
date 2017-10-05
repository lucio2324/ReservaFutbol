package EntidadDAO;

import conexioBD.Conexion;
import entidades.Fecha;
import entidades.Reservas;
import entidades.hora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vitalia Miranda
 */
public class reservasDAO {
    
    
    public String insertarReservas(Reservas r){
      horaDAO horaDao = new horaDAO();
      hora hora = new hora();
      hora.setHora_hora(r.getHora_hora());
      hora.setDisponible_hora(r.getDisponible_hora());
      
      fechaDAO fechaDao = new fechaDAO();
      Fecha fecha = new Fecha();
      fecha.setDiaSemana(r.getDiaSemana());
      fecha.setDia_fecha(r.getDia_fecha());
      fecha.setMes_fecha(r.getMes_fecha());
      fecha.setAno_fecha(r.getAno_fecha());
      
      Integer idHora = horaDao.insertarHora(hora);
      Integer idFecha = fechaDao.insertarFecha(fecha);
      
      String IdHora = idHora.toString();
      String IdFecha = idFecha.toString();
       
        Conexion con = new Conexion();
        Connection reg = con.getConnection();
        PreparedStatement prs = null;
        String sql = "INSERT INTO reservas (id_cliente, id_cancha, id_fecha, id_hora) VALUE (?,?,?,?)";
        
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1, r.getId_cliente());
            prs.setString(2, r.getId_cancha());
            prs.setString(3, IdFecha);
            prs.setString(4, IdHora);
            prs.execute();
            con.desconectar();
            
            return "true";
        } catch (SQLException ex) {
            Logger.getLogger(reservasDAO.class.getName()).log(Level.SEVERE, null, ex);
        return "false";
        }
    }
}
