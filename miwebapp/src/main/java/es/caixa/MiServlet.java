package es.caixa;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import es.caixa.Usuario;
import es.caixa.GestorUsuarios;


public class MiServlet extends HttpServlet{
    
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        String email=req.getParameter("email");
        GestorUsuarios miGestor=new GestorUsuarios();
        Usuario usuarioBorrado=miGestor.getUsuario(email);
        miGestor.borrarUsuario(usuarioBorrado);
 
        resp.setContentType("text/yaml;charset=UTF-8");

        PrintWriter elTextQueMandoAlCliente = resp.getWriter();    
        elTextQueMandoAlCliente.println("Borrado OK");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

        String email=req.getParameter("email");
        
        GestorUsuarios miGestor=new GestorUsuarios();
        
        Usuario usuarioConsultado=miGestor.getUsuario(email);

        resp.setContentType("text/yaml;charset=UTF-8");

        PrintWriter elTextQueMandoAlCliente = resp.getWriter();
        /*
        elTextQueMandoAlCliente.println("<html>");
        elTextQueMandoAlCliente.println("   <body>");
        elTextQueMandoAlCliente.println("       <p>Hola "+nombre+" desde la Servlet</p>");
        elTextQueMandoAlCliente.println("   </body>");
        elTextQueMandoAlCliente.println("</html>");
        */
        elTextQueMandoAlCliente.println("usuario:");
        elTextQueMandoAlCliente.println("   Nombre: "+usuarioConsultado.getNombre());
        elTextQueMandoAlCliente.println("   Edad: "+usuarioConsultado.getEdad());
        elTextQueMandoAlCliente.println("   email: "+usuarioConsultado.getEmail());
        
    }

}