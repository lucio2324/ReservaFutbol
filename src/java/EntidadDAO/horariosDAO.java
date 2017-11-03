package EntidadDAO;

import com.google.gson.Gson;
import conexioBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.prueba;


public class horariosDAO {
    
    public TreeMap recuperarHorarios(){
        ArrayList<TreeMap> lista = new ArrayList();
        ArrayList<TreeMap> lista2 = new ArrayList();
        ArrayList<TreeMap> lista3 = new ArrayList();
        TreeMap<String, ArrayList> temp = new TreeMap();
        String sqlTablaDia = "SELECT valor_dia FROM `dia`";
        String sql3TablaHora = "SELECT * FROM `hora`";
        String sqlTablaHorarios = "SELECT id, id_hora FROM `horarios`";
        Conexion con = new Conexion();
        Connection reg =con.getConnection();

        
        try {
            PreparedStatement prs = reg.prepareStatement(sqlTablaDia);
            ResultSet rs = prs.executeQuery(); 
            while(rs.next()){
                    TreeMap<String, String> temp2 = new TreeMap();
                   temp2.put("valor_dia", rs.getString("valor_dia"));
                   lista.add(temp2);
                }
            temp.put("Array_dia", lista);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         try {
            PreparedStatement prs = reg.prepareStatement(sql3TablaHora);
            ResultSet rs = prs.executeQuery(); 
            while(rs.next()){
                    TreeMap<String, String> temp3 = new TreeMap();
                   temp3.put("id", rs.getString("id"));
                   temp3.put("valor_hora", rs.getString("valor_hora"));
                   lista2.add(temp3);
                }
            temp.put("Array_hora", lista2);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
          try {
            PreparedStatement prs = reg.prepareStatement(sqlTablaHorarios);
            ResultSet rs = prs.executeQuery(); 
            while(rs.next()){
                    TreeMap<String, String> temp4 = new TreeMap();
                   temp4.put("id", rs.getString("id"));
                   temp4.put("id_hora", rs.getString("id_hora"));
                   lista3.add(temp4);
                }
            temp.put("Array_horarios", lista3);
            rs.close();
            con.desconectar();            
        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;
        
    }
}
