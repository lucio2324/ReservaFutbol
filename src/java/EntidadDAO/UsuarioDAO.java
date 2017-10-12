package EntidadDAO;

import conexioBD.Conexion;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {
    
    public String agregarUsuario (Usuario u){
   Integer id = 0;
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="INSERT INTO `usuario` (`nombre_usuario`, `clave_usuario`, `rol_usuario`) VALUES (?,?,?);";
        try {
            prs = reg.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            prs.setString(1, u.getNombre_usuario());
            prs.setString(2, u.getClave_usuario());
            prs.setString(3, u.getRol_usuario());
            prs.execute();
            ResultSet idUsuario = prs.getGeneratedKeys();
            con.desconectar();
            
            if (idUsuario.next()) {
                id = idUsuario.getInt(1);
            }
          String resultdo = id.toString();
            
            return resultdo;
        } catch (SQLException e) {
             return e.getMessage();
        }
     
    }
    
    public String validar (Usuario u){
     
    String resultado = "";    
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="SELECT * FROM `usuario` WHERE nombre_usuario =?";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1, u.getNombre_usuario());
            ResultSet rs = prs.executeQuery(); 
              if (rs.next()) {
               String id = rs.getString(1);
               String nombre = rs.getString(2);
               String clave = rs.getString(3);
               String rol = rs.getString(4);
            
              resultado = id+","+nombre+","+clave+","+rol;
              
              }
              
            con.desconectar();
            return resultado;
            
        } catch (SQLException e) {
             return null;
        }
    }
}
