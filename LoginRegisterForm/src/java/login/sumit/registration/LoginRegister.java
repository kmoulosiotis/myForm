/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.sumit.registration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kostas
 */
@WebServlet(name = "LoginRegister", urlPatterns = {"/loginRegister"})
public class LoginRegister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginRegister</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginRegister at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        StudentDAO st = new StudentDAOImpl();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password1");
        String submitType = request.getParameter("submit");
        
        Student s = st.getStudent(username);
        
        if(submitType.equals("LOG IN") && s != null && s.getFirstName() != null){
            if(s.getPassword().equals(password)){
                request.setAttribute("message", "Hello "+s.getFirstName()+". Welcome!");
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }else{
                request.setAttribute("invalidPassword", "Wrong password. Try again.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if(submitType.equals("SIGN UP")){
            String conPassword = request.getParameter("password2");
            String fn = request.getParameter("first-name");
            String ln = request.getParameter("last-name");
            String em = request.getParameter("email");
            if(username.equals("") || fn.equals("") || em.equals("") || password.equals("") || conPassword.equals("")){
                request.setAttribute("missingArgs", "Missing information");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }else if(s.getUsername() != null){
                request.setAttribute("includedMessage", "Username already exists");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }else{
                if(conPassword.equals(password)){
                    s.setUsername(username);
                    s.setFirstName(fn);
                    s.setLastName(ln);
                    s.setEmail(em);
                    s.setPassword(password);
                    st.addStudent(s);
                    request.setAttribute("successMessage", "Registration complete. Log in to continue!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }else{
                        request.setAttribute("diffPassword", "The passwords do not match");
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            }
        }else if(submitType.equals("Confirm")){
            int status = st.delStudent(s);
            if(status != 0){
                request.setAttribute("successDel", "Account deleted successfully");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                request.setAttribute("failDel", "Wrong username or password");
                request.setAttribute("message", "");
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("wrongMessage", "User not found. Please create an account.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
