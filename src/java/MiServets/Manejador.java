package MiServets;

import EntidadDAO.ClienteDAO;
import EntidadDAO.UsuarioDAO;
import EntidadDAO.clubDAO;
import EntidadDAO.reservasDAO;
import Tokens.CodificarToken;
import com.google.gson.Gson;
import entidades.Reservas;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Manejador", urlPatterns = {"/Manejador"})
public class Manejador extends HttpServlet {

    
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
       PrintWriter out = response.getWriter();
       String nombreU = request.getParameter("email");
       String datosREcividos = request.getReader().readLine();

        Gson gson = new Gson();
        Usuario nuevoUsuario =gson.fromJson(datosREcividos, Usuario.class);
        
       UsuarioDAO validar = new UsuarioDAO();
        String resul = validar.validar(nuevoUsuario);
       
       String[] resultado = resul.split(",");
       String id = resultado[0];
       String nombre = resultado[1];
       String clave= resultado[3];
       String rol = resultado[4];
       
       if (nombre.equals(nuevoUsuario.getNombre_usuario()) && clave.equals(nuevoUsuario.getClave_usuario())){
           
           CodificarToken token = new CodificarToken();
           
           String res = token.token(nuevoUsuario.getNombre_usuario());
           
           out.print(res);
       }else{
           out.print("El usuario o la contraseñan con incorrectos");
     }
 }
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         PrintWriter out = response.getWriter();
         String datosRecividos = request.getReader().readLine();

        Gson gson = new Gson();
        Usuario nuevoUsuario = gson.fromJson(datosRecividos, Usuario.class);
        UsuarioDAO validar = new UsuarioDAO();
        
if (nuevoUsuario.getRol_usuario() == null) {
        
        String resul = validar.validar(nuevoUsuario);
    if (resul != null) {
       String[] resultado = resul.split(",");
       String id = resultado[0];
       String nombre = resultado[1];
       String clave= resultado[2];
       String rol = resultado[3];
       
       if(clave.equals(nuevoUsuario.getClave_usuario())){
           
           CodificarToken token = new CodificarToken();
           
           String res = token.token(nuevoUsuario.getNombre_usuario());
           
           out.print(res);
       }else {
       out.print("La contraseña es incorrecta");
       }
   }else {
    out.print("El usuario o la contraseñan con incorrectos");
    }
       
}else{
        
        clubDAO ingresarClub = new clubDAO();
        ClienteDAO ingresarCliente = new ClienteDAO();
        
        String resul = validar.validar(nuevoUsuario);
       
    if (resul.equals("")) {
            String result ="";
        String rol = nuevoUsuario.getRol_usuario();
        if (rol.equals("administrador")) {
             ingresarClub.agregarClub(nuevoUsuario);
             result = "Ok";
        }else{
             ingresarCliente.agregarCliente(nuevoUsuario);
             result = "Ok";
        }
        out.print(result);
    }else{
        out.print("El usuario ya existe");
        }  
    }
  }
}
