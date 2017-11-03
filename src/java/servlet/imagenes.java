package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "imagenes", urlPatterns = {"/imagenes"})
@MultipartConfig

public class imagenes extends HttpServlet {

    private final static String  rutafisica2 = "/home/alvaro/Escritorio/carpeta/SistemaReserva-master/sistemaReserva/web/imagenes/";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("hola");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        
        String tamanio = request.getParameter("tamanio");
        String descripcion = request.getParameter("superficie");
        Part arch = request.getPart("imagen");
        
//        DEVUELVE NOMBRE DEL ARCHIVO
        String nombarch = Paths.get(arch.getSubmittedFileName()).getFileName().toString();
        
        out.println(tamanio);
        out.println(descripcion);
        out.println(nombarch);

        out.println("-------------------------------------------");

        out.println(rutafisica2);

        InputStream is = arch.getInputStream();

        File f = new File(rutafisica2);
        File f2 = new File(rutafisica2 + nombarch);
                
        out.println();

        if (f.exists()) {

            FileOutputStream ous = new FileOutputStream(f2);
            int dato = is.read();
            while (dato != -1) {
                ous.write(dato);
                dato = is.read();
            }
            out.println("fin");
        } else {

            f.mkdir();

            FileOutputStream ous = new FileOutputStream(f2);
            int dato = is.read();
            while (dato != -1) {
                ous.write(dato);
                dato = is.read();
            }
            out.println("fin");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
