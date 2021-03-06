package MiServets;

import EntidadDAO.canchaDAO;
import com.google.gson.Gson;
import entidades.Cancha;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vitalia Miranda
 */
@WebServlet(name = "GuardarCancha", urlPatterns = {"/GuardarCancha"})
public class GuardarCancha extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       
        String idCancha = request.getParameter("id_cancha");
        canchaDAO cancha = new canchaDAO();
        Gson gson = new Gson();
        List horas = cancha.recuperarHorasCancha(idCancha);
        TreeMap horasDiponibles = new TreeMap<>();
            
        horasDiponibles.put("Array_horasDisponibles", horas);
        String resul=gson.toJson(horasDiponibles);
        out.println(resul);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
            PrintWriter out = response.getWriter();
         String datosRecibidos = request.getReader().readLine();
         
         canchaDAO insertarCancha= new canchaDAO();
        Gson gson = new Gson();
        Cancha nuevaCancha =gson.fromJson(datosRecibidos, Cancha.class);
       
       String respuesta =  insertarCancha.InsertarCancha(nuevaCancha);
        
       out.print(respuesta);
        
    }



}
