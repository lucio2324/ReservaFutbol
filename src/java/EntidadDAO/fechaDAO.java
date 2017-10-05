package EntidadDAO;


import conexioBD.Conexion;
import entidades.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fechaDAO {
    
public int insertarFecha(Fecha f){
    int id=0;
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="INSERT INTO `fecha` (`diaDeSemana`, `dia_fecha`, `mes_fecha`, `ano_fecha`) VALUES (?,?,?,?)";
        try {
            prs = reg.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            prs.setString(1, f.getDiaSemana());
            prs.setString(2, f.getDia_fecha());
            prs.setString(3, f.getMes_fecha());
            prs.setString(4, f.getAno_fecha());
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
