package com.botog;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author botog
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        EmployeeDAO empDAO = new EmployeeDAO();
        Employee emp = null;
        String dest = "index.html";
        
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        
        try {
            emp = empDAO.check(email, pass);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(emp != null) {
            dest = "welcome.jsp";
            session.setAttribute("emp", emp);
        } else {
            String message = "Invalid email/password";
            request.setAttribute("message", message);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(dest);
        rd.forward(request, response);
    }

}
