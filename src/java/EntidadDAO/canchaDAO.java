package EntidadDAO;

import conexioBD.Conexion;
import entidades.Cancha;
import entidades.Horarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class canchaDAO {
    
    public String InsertarCancha (Cancha c){
    
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="INSERT INTO `cancha`( `tamanio_cancha`, `superficie_cancha`, `foto_cancha`, `id_club`) VALUES (?,?,?,?)";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1, c.getTamanio());
            prs.setString(2, c.getSuperficie());
            prs.setString(3, c.getFoto());
            prs.setString(4, c.getId_club());
            prs.execute();
            con.desconectar();
           return "ok";
           
           
        } catch (SQLException ex) {
        return "false"+ex;
    }
    
    }
        
 public List recuperarCancha(String id){
     
    List resultado = new ArrayList();
    List errores = new ArrayList();
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="SELECT * FROM `cancha` WHERE id_club =?";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1,id);
            ResultSet rs = prs.executeQuery(); 
             con.desconectar();
             ResultSetMetaData md = rs.getMetaData();
              int columns = md.getColumnCount();
             
            while(rs.next()) {
                HashMap row = new HashMap();
                resultado.add(row);
              
                for (int i = 1; i <= columns; i++) {
                    row.put(md.getColumnName(i),rs.getString(i));
                }
                
            }  return resultado;
            
        } catch (SQLException e) {
           
             errores.add(e);
            System.out.println(e);
             return errores;
        }
    }   
 
 public List recuperarNombreCancha(String id){
     
    List resultado = new ArrayList();
    List errores = new ArrayList();
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="SELECT id_cancha , tamanio_cancha FROM `cancha` WHERE id_club =?";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1,id);
            ResultSet rs = prs.executeQuery(); 
             con.desconectar();
             ResultSetMetaData md = rs.getMetaData();
              int columns = md.getColumnCount();
             
            while(rs.next()) {
                TreeMap<String, String> cancha = new TreeMap();
                   cancha.put("id_cancha", rs.getString("id_cancha"));
                   cancha.put("tamanio_cancha", rs.getString("tamanio_cancha"));
                   resultado.add(cancha);
                
            }  return resultado;
            
        } catch (SQLException e) {
           
             errores.add(e);
            System.out.println(e);
             return errores;
        }
    }   
 
  public List recuperarHorasCancha(String id){
     
    List resultado = new ArrayList();
    List errores = new ArrayList();
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="SELECT disponibleAlquiler_cancha FROM `cancha` WHERE id_cancha =?";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1,id);
            ResultSet rs = prs.executeQuery(); 
             
            while(rs.next()) {
                TreeMap<String, String> cancha = new TreeMap();
                   cancha.put("disponibleAlquiler_cancha", rs.getString("disponibleAlquiler_cancha"));
                   resultado.add(cancha);
                
            } 
            con.desconectar();
            return resultado;
            
        } catch (SQLException e) {
           
             errores.add(e);
            System.out.println(e);
             return errores;
        }
    }
  public String eliminarCancha(String id){
  String resul = "";
  Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="DELETE FROM `cancha` WHERE `cancha`.`id_cancha` = ?";
        
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1,id);
            prs.execute(); 
             con.desconectar();
             resul = "Se elimino correctamente";
             
             return resul;
        } catch (SQLException ex) {
         return ex.getMessage();
        }
  }
  
public String ingresarHorarios(Horarios h){
   
    String tabla = "disponible"+h.getDescripcion()+"_cancha";
    String horas = "";
    
    
    for (int i = 0; i < h.getHorario_id().size(); i++) {
        horas += h.getHorario_id().get(i)+",";
    }
    
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="UPDATE `cancha` SET disponibleAlquiler_cancha = ?  WHERE `cancha`.`id_cancha` = ? ";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1,horas);
            prs.setString(2,h.getCancha_id());
            prs.execute(); 
            con.desconectar();
            return "ok";
            
        } catch (SQLException e) {
         
             return e.getMessage();
        }
    }
     
 
}