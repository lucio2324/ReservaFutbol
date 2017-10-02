package EntidadDAO;

import conexioBD.Conexion;
import entidades.Club;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class clubDAO {
    
        public String agregarClub(Club c){
    String resultdo = "Se Gurdao correctamente el club";
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="INSERT INTO `club` (`nombre_club`, `clave`, `direccion_chub`, `telefono_club`, `administrador_club`) VALUES(?,?,?,?,?)";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1, c.getNombreClub());
            prs.setString(2, c.getClaveClub());
            prs.setString(3, c.getDireccionClub());
            prs.setString(4, c.getTelefonoClub());
            prs.setString(5, c.getAdministradorClub());
            prs.execute();
            con.desconectar();
            
            return resultdo;
        } catch (SQLException e) {
             return e.getMessage();
        }
     
    }
        
public String validar(String nombre){
     
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="SELECT * FROM `club` WHERE nombre_club =?";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1, nombre);
            ResultSet rs = prs.executeQuery(); 
             con.desconectar();
            if (rs.next()) {
                 return "false";
            }else{
            return "true";
            }
        } catch (SQLException e) {
             return e.getMessage();
        }
    }

  public String login (Club c){
     
          String id = null;
          String nombreClub = null;
          String clave =null;
          String direccion = null;
          String telefono =null;
          String administrador = null;
    String resultado=null;
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="SELECT * FROM `club` WHERE nombre_usuario =?";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1, c.getNombreClub());
            ResultSet rs = prs.executeQuery(); 
              if (rs.next()) {
                 id = rs.getString(1);
                 nombreClub = rs.getString(2);
                 clave = rs.getString(3);
                 direccion = rs.getString(4);
                 telefono = rs.getString(5);
                 administrador = rs.getString(6);
            }
       
              resultado = id+","+nombreClub+","+clave+","+direccion+","+telefono+","+administrador;
              
            con.desconectar();
            
            return resultado;
        } catch (SQLException e) {
             return e.getMessage();
        }
    }
}


