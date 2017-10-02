package EntidadDAO;


import conexioBD.Conexion;
import entidades.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class fechaDAO {
    
    public List recuperaPorFecha (Fecha f){
    
    List resultado = new ArrayList();
    List errores = new ArrayList();
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="SELECT nombre_cancha, hora_hora, disponible_hora FROM hora ,fecha ,cancha WHERE dia_fecha=? AND mes_fecha=? AND ano_fecha=?";
        try {
            prs = reg.prepareStatement(sql);
            prs.setString(1, f.getDia_fecha());
            prs.setString(2, f.getMes_fecha());
            prs.setString(3, f.getAno_fecha());
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
                
            }
            return resultado;
        } catch (SQLException e) {
            errores.add(e);
            System.out.println(e);
             return errores;
        }
    }
}
