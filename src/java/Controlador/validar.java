
package Controlador;

import Modelo.Administrador;
import Modelo.Cliente;
import ModeloDAO.AdministradorDAO;
import ModeloDAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class validar extends HttpServlet {

    AdministradorDAO admidao = new AdministradorDAO();
    Administrador admin = new Administrador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String accion = request.getParameter("accion");
        
        if (accion.equalsIgnoreCase("login")) {
            String admin_cod = request.getParameter("email");
            String admin_pass = request.getParameter("pass");
            admin = admidao.validar(admin_cod, admin_pass);
            if (admin.getAdmin_cod()!=null) {
                request.setAttribute("admin_cod", admin);
                request.getRequestDispatcher("Control?accion=Administracion").forward(request, response);
            }else{
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Login.jsp").forward(request, response);     
       }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
