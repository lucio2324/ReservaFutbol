package servlet;

import EntidadDAO.UsuarioDAO;
import EntidadDAO.canchaDAO;
import EntidadDAO.horariosDAO;
import com.google.gson.Gson;
import conexioBD.Conexion;
import entidades.Horarios;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "prueba", urlPatterns = {"/prueba"})
public class prueba extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String idClub = request.getParameter("id_club");
        String idCancha = request.getParameter("id_cancha");
        canchaDAO cancha = new canchaDAO();
        horariosDAO recuperar = new horariosDAO();
        List canchas = cancha.recuperarNombreCancha(idClub);
        TreeMap temp = recuperar.recuperarHorarios();
        temp.put("Array_cancha", canchas);
        
        Gson gson = new Gson();
        out.println(gson.toJson(temp));
        if (idCancha != null) {
            List horas = cancha.recuperarHorasCancha(idCancha);
            TreeMap horasDiponibles = new TreeMap<>();
            
            horasDiponibles.put("Array_horasDisponibles", horas);
        out.println(gson.toJson(horasDiponibles));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out =response.getWriter();
            String texto = request.getReader().readLine();
            
            out.println(texto);
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     PrintWriter out = response.getWriter();
         String datosRecividos = request.getReader().readLine();

        Gson gson = new Gson();
        Horarios nuevoHorario = gson.fromJson(datosRecividos, Horarios.class);
        canchaDAO IngresarHorarios = new canchaDAO();
   String resul = IngresarHorarios.ingresarHorarios(nuevoHorario);
   
    out.print(resul);
    }

}
