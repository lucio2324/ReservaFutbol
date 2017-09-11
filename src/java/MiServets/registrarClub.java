package MiServets;

import EntidadDAO.clubDAO;
import com.google.gson.Gson;
import entidades.Club;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "registrarClub", urlPatterns = {"/registrarClub"})
public class registrarClub extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        try {
            Gson gson = new Gson();
        String json = gson.toJson(request);
        Club nuevoClub = gson.fromJson(json, Club.class);
        
          
        
      clubDAO login = new clubDAO();
      String res = login.login(nuevoClub);
        
              if (res.equals("")) {
                out.print("No se pudo encontrar el usuario");
            }else {
              
              out.print(res);
              }
            
            
        } catch (Exception e) {
        out.print("Se produjo el siginete error: "+e);
        } 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String nombre = request.getParameter("nombreClub");
        String clave = request.getParameter("claveClub");
        String direccion = request.getParameter("direccionClub");
        String telefono = request.getParameter("telefonoClub");
        String administrador = request.getParameter("administradorClub");
        
        PrintWriter out = response.getWriter();
        
        Club nuevoClub = new Club();
        nuevoClub.setNombre_club(nombre);
        nuevoClub.setClave(clave);
        nuevoClub.setDireccion(direccion);
        nuevoClub.setTelefono(telefono);
        nuevoClub.setNombreAdministracion(administrador);
        
        
        clubDAO agregar = new clubDAO();
        String validacion = agregar.validar(nombre);
        if (validacion.equals("true")) {
            String resp = agregar.agregarClub(nuevoClub);
        
            out.print(resp);
        }else {
        out.print("El club ya existe");
        }
        
        
    }

}
