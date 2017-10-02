package MiServets;

import EntidadDAO.clubDAO;
import com.google.gson.Gson;
import entidades.Club;
import java.io.IOException;
import java.io.PrintWriter;
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
         String text = request.getReader().readLine();
        try {
            Gson gson = new Gson();
        //String json = gson.toJson(request);
        Club nuevoClub = gson.fromJson(text, Club.class);
        
      clubDAO login = new clubDAO();
      String res = login.login(nuevoClub);
        
              if (res.equals("")) {
                out.print("No se pudo encontrar el usuario");
            }else {
              
              out.print("true");
              }
            
            
        } catch (Exception e) {
        out.print("Se produjo el siginete error: "+e);
        } 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        response.setContentType("text/html;charset= UTF-8");
        String text= request.getReader().readLine();
       // String clave = request.getParameter("claveClub");
       // String direccion = request.getParameter("direccionClub");
       // String telefono = request.getParameter("telefonoClub");
       // String administrador = request.getParameter("administradorClub");
        
        PrintWriter out = response.getWriter();
        
          Gson gson = new Gson();
        //String json = gson.toJson(text);
        Club club = gson.fromJson(text, Club.class);
        
        
        clubDAO agregar = new clubDAO();
        String validacion = agregar.validar(club.getNombreClub());
        if (validacion.equals("true")) {
            String resp = agregar.agregarClub(club);
         
            out.print(resp);
        }else {
        out.print("El club ya existe");
        }
        
        
    }

}
