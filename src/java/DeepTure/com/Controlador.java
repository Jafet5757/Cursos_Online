package DeepTure.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAFET
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    
    private Modelo modelo;
    
    //definir o establecer el datasource
    @Resource(name="jdbc/Productos")
    private DataSource miPool;

    @Override
    public void init() throws ServletException {
        super.init(); 
        try{
            modelo = new Modelo(miPool);
        }catch(Exception e){
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            String instruction = request.getParameter("instruccion");
            switch (instruction){
                case "crearUsuario":
                {
                    try {
                        crearUsuario(request, response);
                    } catch (Exception ex) {
                        out.println(ex);
                    }
                }
                break;
                case "iniciarSesion":
                    try{
                        comprobarUsuario(request, response);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                break;
                case "borraCuenta":
                    try{
                        borrarUsuario(request, response);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                break;
                case "actualizarDatos":
                
                    try {
                        actualizarDatosUsuario(request,response);
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;


            }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            String galleta=null,contra=null;
            String nameGalleta=null;
            Cookie[] lasCookies=request.getCookies();
         // Obtenemos las cookies
         if(lasCookies!=null){
             for(Cookie cookieTemp : lasCookies){
                 if("Usuario".equals(cookieTemp.getName())){
                     galleta=cookieTemp.getValue();
                     nameGalleta=cookieTemp.getName();
                 }
                 if("password".equals(cookieTemp.getName())){
                     contra=cookieTemp.getValue();
                 }
             }
         }  
            switch(nameGalleta){
                case "Usuario":
                {
                    try {
                        cargarSettings(request,response,galleta,contra);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                break;

            }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void crearUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        String nombre=request.getParameter("name");
        String apellidoP=request.getParameter("app");
        String apellidoM=request.getParameter("apm");
        String curp=request.getParameter("curp");
        String fecha=request.getParameter("nac");
        String direccion=request.getParameter("dir");
        String cp=request.getParameter("cp");
        String tel=request.getParameter("tel");
        String user=request.getParameter("usuario");
        String password=request.getParameter("password1");
        String pass=request.getParameter("password2");
        
        Usuario nuevoUsuario=new Usuario(nombre, apellidoP, apellidoM, curp, fecha, direccion, cp, tel, user, password);
        boolean seCreo=modelo.agregarUsuario(nuevoUsuario);
        if(seCreo){
                Usuario datosUsuario=new Usuario(nombre,apellidoP,apellidoM,curp,fecha,direccion,cp,tel,user,password);
                List<Usuario> datos=new ArrayList();
                datos.add(datosUsuario);
                //agregar los datos del usuario al request
                request.setAttribute("datosDelUsuario", datos);
                //enviar ese request a la pagina jsp
                RequestDispatcher disp=request.getRequestDispatcher("/Home.jsp");
                disp.forward(request, response);
        }else{
            out.println("<script>alert('Ha ocurrido un error')</script>");
        }
    }

    private void comprobarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String user=request.getParameter("name");
        String password=request.getParameter("password");
       
        PrintWriter out = response.getWriter();
        
        Usuario comprobarExistencia=new Usuario(user, password);
        List<Usuario> existe=modelo.iniciarSesion(comprobarExistencia);
        
        if(Modelo.entra){
            try{
                //agregar los datos del usuario al request
                request.setAttribute("datosDelUsuario", existe);
                //enviar ese request a la pagina jsp
                RequestDispatcher disp=request.getRequestDispatcher("/Home.jsp");
                disp.forward(request, response);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            out.println("<script>alert('No existe el usuario')</script>");
            
            request.setAttribute("datosDelUsuario", "no");
            RequestDispatcher disp=request.getRequestDispatcher("/iniciarSesion.html");
            try {
                disp.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        modelo.closeEntrada();
        
    }

    private void borrarUsuario(HttpServletRequest request, HttpServletResponse response)throws Exception {
        PrintWriter out = response.getWriter();
        String nombre=request.getParameter("user");
        String contrasena=request.getParameter("pass");
        
        Usuario borrarCuenta=new Usuario(nombre,contrasena);
        
        List<Usuario> existe=modelo.iniciarSesion(borrarCuenta);
        if(Modelo.entra){
            modelo.borrarUsuario(borrarCuenta);
            RequestDispatcher disp=request.getRequestDispatcher("/iniciarSesion.html");
            disp.forward(request, response);
        }else{
            out.println("Usted no tiene acceso a la cuenta");
        }
        modelo.closeEntrada();
    }

    private void cargarSettings(HttpServletRequest request, HttpServletResponse response, String galleta, String contra)throws Exception {
        
        Usuario comprobarExistencia=new Usuario(galleta, contra);
        
        List<Usuario> datos=modelo.iniciarSesion(comprobarExistencia);
        
        if(Modelo.entra){
            try{
                //agregar los datos del usuario al request
                request.setAttribute("datosDelUsuario", datos);
                //enviar ese request a la pagina jsp
                RequestDispatcher disp=request.getRequestDispatcher("/Setting.jsp");
                disp.forward(request, response);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        modelo.closeEntrada();
    }

    private void actualizarDatosUsuario(HttpServletRequest request, HttpServletResponse response)throws Exception {
        String nombre=request.getParameter("name");
        String apellidoP=request.getParameter("app");
        String apellidoM=request.getParameter("apm");
        String curp=request.getParameter("curp");
        String fecha=request.getParameter("nac");
        String direccion=request.getParameter("dir");
        String cp=request.getParameter("cp");
        String tel=request.getParameter("tel");
        String user=request.getParameter("usuario");
        String password=request.getParameter("password");
        //String pass=request.getParameter("password2");
        
        PrintWriter out = response.getWriter();
        
        Usuario userUpdate=new Usuario(nombre, apellidoP, apellidoM, curp, fecha, direccion, cp, tel, user, password);
        
        modelo.userUpdate(userUpdate);
        
        comprobarUsuario(request, response);
        
    }

}
