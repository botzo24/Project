package com.botog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    public Employee check(String email, String password) throws SQLException,
            ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Employee emp = null;

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "Carte12345!@#$%");
            
        PreparedStatement ps = con.prepareStatement("SELECT * FROM registration_data WHERE email = ? and pwd = ?");
        ps.setString(1, email);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
            emp = new Employee();
            emp.setFirst_name(rs.getString("first_name"));
            emp.setLast_name(rs.getString("last_name"));
        }
        
        return emp;
    }
}
