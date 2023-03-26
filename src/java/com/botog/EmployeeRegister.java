package com.botog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author botog
 */
@WebServlet(name = "EmployeeRegister", urlPatterns = {"/EmployeeRegister"})
public class EmployeeRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        
        String lastName = request.getParameter("lastname");
        String firstName = request.getParameter("firstname");
        String pass = request.getParameter("password");
        String email = request.getParameter("mail");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "Carte12345!@#$%");
           
           PreparedStatement ps = con.prepareStatement
                   ("insert into registration_data (first_name, last_name, pwd, email) values(?,?,?,?)");
           
            ps.setString(1, lastName);
            ps.setString(2, firstName);
            ps.setString(3, pass);
            ps.setString(4, email);
            		
            int i = ps.executeUpdate();
            
            if(i > 0) {
		out.println("You are successfully registered at TechPilot");
            }
        } catch(Exception e) {
		e.printStackTrace();
	}
    }
}
