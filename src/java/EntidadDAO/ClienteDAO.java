package EntidadDAO;

import conexioBD.Conexion;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {
    
    public String agregarCliente(Usuario u){
    UsuarioDAO ingresarUsurio = new UsuarioDAO();
    String idUsuario = ingresarUsurio.agregarUsuario(u);
     
     Integer id =0;
    String resultdo = "";
    Conexion con = new Conexion();
    Connection reg = con.getConnection();
    PreparedStatement prs = null;
    String sql ="INSERT INTO `cliente` (`nombre_cliente`, `telefono_cliente`, `E-mail_cliente`, `foto_cliente`, `id_usuario`) VALUES (?,?,?,?,?);";
        try {
            prs = reg.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            prs.setString(1,u.getNombre_usuario());
            prs.setString(2, null);
            prs.setString(3, u.getEmail_usuario());
            prs.setString(4,null);
            prs.setString(5,idUsuario);
            prs.execute();
            ResultSet idCliente = prs.getGeneratedKeys();
            con.desconectar();
            
            if (idCliente.next()) {
                id = idCliente.getInt(1);
            }
            resultdo = id.toString();
            return resultdo;
        } catch (SQLException e) {
             return e.getMessage();
        }
    }
}
