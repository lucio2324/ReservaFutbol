package MiServets;

import EntidadDAO.canchaDAO;
import com.google.gson.Gson;
import entidades.Cancha;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(name = "resivrFoto", urlPatterns = {"/resivrFoto"})
@MultipartConfig
public class resivrFoto extends HttpServlet {
public static  final String aEnviar = "C:/Users/Vitalia Miranda/Desktop/SistemaReservaV2/web/imagenes/";
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       String idClub = request.getParameter("id_club");
       
        Gson gson = new Gson();
       canchaDAO recuperar = new canchaDAO();
       
        List resul =  recuperar.recuperarCancha(idClub);
       String respuesta = gson.toJson(resul);
       
       out.print(respuesta);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String nombre = request.getParameter("tamanio");
        String superficie = request.getParameter("superficie");
        String idClub = request.getParameter("idClub");
        Part archivo = request.getPart("imagen");
        
        String nombreArchivo = Paths.get(archivo.getSubmittedFileName()).getFileName().toString();
        
        InputStream is = archivo.getInputStream();
        
        File f = new File(this.aEnviar + nombreArchivo);
        FileOutputStream ous = new FileOutputStream(f);
        int dato = is.read();
        while (dato != -1) {
            ous.write(dato);
            dato = is.read();
        }
        
        Cancha cancha = new Cancha();
        canchaDAO ingresar = new canchaDAO();
        
        cancha.setTamanio(nombre);
        cancha.setSuperficie(superficie);
        cancha.setFoto(nombreArchivo);
        cancha.setId_club(idClub);
        
        String respuesta = ingresar.InsertarCancha(cancha);
       
   out.print(respuesta);
        
    }
    
     @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    PrintWriter out = response.getWriter();
       String idCancha = request.getParameter("id_cancha");
    String nombreFoto = request.getParameter("nombreFoto");
    File f =new File(this.aEnviar + nombreFoto);
    f.delete();
       canchaDAO eliminar = new canchaDAO();
       
       String resul = eliminar.eliminarCancha(idCancha);
       
    out.print(resul);
    }

}
