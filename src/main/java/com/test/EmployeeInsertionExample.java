package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connectivity.DBConnectivity;


public class EmployeeInsertionExample {
	
	public static String INSERT_EMPLOYEE_QUERY ="insert into employee (empid,name) values(?,?)";
    public static String INSERT_ADDRESS_QUERY ="insert into address(empid,address,city,country) values(?,?,?,?)";


  //This is example we are seeing transaction of two queries insert employee data 
    public static void insertEmployeeData(Connection con,int id,String name) throws SQLException
    {
        
        
        PreparedStatement stmt = con.prepareStatement(INSERT_EMPLOYEE_QUERY);
        stmt.setInt(1, id);
        stmt.setString(2, name);
        
        stmt.executeUpdate();
        
        System.out.println("Employee Data Inserted Successfully for ID" +id);
        
        stmt.close();
        
    }


  //This is example we are seeing transaction of two queries insert  employee address 

    public static void insertEmployeeAddress(Connection con, int id, String address, String city, String country) throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement(INSERT_ADDRESS_QUERY);
        stmt.setInt(1, id);
        stmt.setString(2, address);
        stmt.setString(3, city);
        stmt.setString(4, country);
        
        
        stmt.executeUpdate();
        
        System.out.println("Employee Address Data Inserted Successfully for ID" +id);
            stmt.close();

    }
    
    public static void main(String args[])
    {
        
        Connection con =null;
        try {
            
            con = DBConnectivity.getConnection();
            
            insertEmployeeData(con,1,"Deepak");
            
            insertEmployeeAddress(con,1,"1 Main Rd","Bangalore","India");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(con!=null)
                {
                    con.close();
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }


    }



}
