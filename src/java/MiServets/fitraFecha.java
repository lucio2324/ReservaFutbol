/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiServets;

import EntidadDAO.fechaDAO;
import com.google.gson.Gson;
import entidades.Fecha;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vitalia Miranda
 */
@WebServlet(name = "fitraFecha", urlPatterns = {"/fitraFecha"})
public class fitraFecha extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
     PrintWriter out = response.getWriter();
         String fecha = request.getReader().readLine();
    
        Gson gson = new Gson();
        Fecha nuevaFecha =gson.fromJson(fecha, Fecha.class);
        
        fechaDAO recuperarPorFecha = new fechaDAO();
        List horaFiltrarFecha = recuperarPorFecha.recuperaPorFecha(nuevaFecha);
        
        String respuesta = gson.toJson(horaFiltrarFecha);
        
        out.print(respuesta);   
    }
    
    
}
