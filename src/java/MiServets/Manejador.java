package MiServets;

import EntidadDAO.ClienteDAO;
import EntidadDAO.UsuarioDAO;
import EntidadDAO.clubDAO;
import Tokens.CodificarToken;
import com.google.gson.Gson;
import entidades.Cliente;
import entidades.Club;
import entidades.ClubM;
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
       String id_club= request.getParameter("id_club");
       
       Gson gson = new Gson();
      clubDAO validar = new clubDAO();
      Club club = validar.validar(id_club);
      
      String resul= gson.toJson(club);
      out.print(resul);
     
 }
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         PrintWriter out = response.getWriter();
         String datosRecividos = request.getReader().readLine();

        Gson gson = new Gson();
        Usuario nuevoUsuario = gson.fromJson(datosRecividos, Usuario.class);
        UsuarioDAO validar = new UsuarioDAO();
  //Entra en logeo      
if (nuevoUsuario.getRol_usuario() == null) {
        
        String resul = validar.validar(nuevoUsuario);
    if (!"".equals(resul)) {
       String[] resultado = resul.split(",");
       String id = resultado[0];
       String nombre = resultado[1];
       String clave= resultado[2];
       String rol = resultado[3];
       
       if(clave.equals(nuevoUsuario.getClave_usuario())){
           CodificarToken token = new CodificarToken();
           clubDAO recuperar = new clubDAO();
           Cliente cliente = new Cliente();
           Club club = new Club();
           String res = "";
           if (rol.equals("administrador")){
             res = token.token(nuevoUsuario.getNombre_usuario());  
               String id_club = recuperar.recuperarId(id);
               
            club.setToken(res);
            club.setId_club(id_club);
            
           String respuesta = gson.toJson(club);
           out.print(respuesta);
           }else {
            res = token.token(nuevoUsuario.getNombre_usuario());
           
           out.print(res);
           }
           
           
           
       }else {
       out.print("La contraseña es incorrecta");
       }
   }else {
    out.print("El usuario o la contraseñan con incorrectos");
    }
 //Entra registro      
}else{
        
        clubDAO ingresarClub = new clubDAO();
        ClienteDAO ingresarCliente = new ClienteDAO();
        
        String resul = validar.validar(nuevoUsuario);
       
    if (resul.equals("")) {
            String result ="";
        String rol = nuevoUsuario.getRol_usuario();
        if (rol.equals("administrador")) {
          result = ingresarClub.agregarClub(nuevoUsuario);
        out.print("ok");
        }else{
          result = ingresarCliente.agregarCliente(nuevoUsuario); 
        out.print("ok");
        }  
    }else{
        out.print("El usuario ya existe");
        }  
    }
  }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
       String datosREcividos = request.getReader().readLine();

        Gson gson = new Gson();
        Club nuevoUsuario = gson.fromJson(datosREcividos, Club.class);
        clubDAO modificar = new clubDAO();
        
        String resul = modificar.modificarClub(nuevoUsuario);
        
        out.print(resul);
        
    }
}
