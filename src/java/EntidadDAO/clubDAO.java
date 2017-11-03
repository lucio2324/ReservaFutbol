package EntidadDAO;

import conexioBD.Conexion;
import entidades.Club;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class clubDAO {
    
  public String agregarClub(Usuario u){
     UsuarioDAO ingresarUsurio = new UsuarioDAO();
     String idUsuario = ingresarUsurio.agregarUsuario(u);
     
     Integer id =0;
    String resultdo = "";
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="INSERT INTO `club` (`nombre_club`, `direccion_chub`, `telefono_club`, `e-mail_club`,`foto_usuario`, `id_usuario`) VALUES (?,?,?,?,?,?)";
        try {
            prs = reg.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            prs.setString(1,u.getNombre_usuario());
            prs.setString(2, null);
            prs.setString(3,null);
            prs.setString(4, u.getEmail_usuario());
            prs.setString(5,null);
            prs.setString(6,idUsuario);
            prs.execute();
            ResultSet idClub = prs.getGeneratedKeys();
            con.desconectar();
            
            if (idClub.next()) {
                id = idClub.getInt(1);
            }
            resultdo = id.toString();
            return resultdo;
        } catch (SQLException e) {
             return e.getMessage();
        }
     
    }
        
public Club validar(String id){
     
    Club club = new Club();
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="SELECT * FROM `club` WHERE id_club =?";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1,id);
            ResultSet rs = prs.executeQuery(); 
             con.desconectar();
            if (rs.next()) {
      
                club.setId_club(rs.getString(1));
                club.setNombre_Club(rs.getString(2));
                club.setDireccion_Club(rs.getString(3));
                club.setTelefono_Club(rs.getString(4));
                club.setMail_Club(rs.getString(5));
                club.setFoto_Club(rs.getString(6));  
            }
            return club;
        } catch (SQLException e) {
            club.setNombre_Club(e.getMessage());
             return club;
        }
    }

public String recuperarI(String id){
     
    
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="SELECT * FROM `club` WHERE id_usuario =?";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1,id);
            ResultSet rs = prs.executeQuery(); 
             con.desconectar();
     
             if (rs.next()) {
      
               String resul = rs.getString(1);
                 return resul;
            }
            
        } catch (SQLException e) {
           
             return e.getMessage();
        }
      return null;
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
            prs.setString(1, c.getNombre_Club());
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
  
   public String modificarClub (Club c){
  Conexion con = new Conexion();
  Connection reg = con.getConnection();
  PreparedStatement prs = null;
  String sql = "UPDATE `club` SET `nombre_club` = ?,`direccion_club` = ?,`e-mail_club` = ? WHERE `club`.`id_club` = ?";
      try {
          prs = reg.prepareStatement(sql);
          prs.setString(1,c.getNombre_Club());
          prs.setString(2,c.getDireccion_Club());
          prs.setString(3,c.getMail_Club());
          prs.setString(4,c.getId_club());
          prs.execute();
         con.desconectar();
         
         return "ok";
      } catch (SQLException ex) {
          return ex.getMessage();
      }
  }
}


