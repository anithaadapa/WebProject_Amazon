package com.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.connectivity.DBConnectivity;

public class EmployeeInsertionFix {

	public static void main(String args[])
    {
        
        Connection con =null;
        try {
            
            con = DBConnectivity.getConnection();
            
            //set auto commit to false
            con.setAutoCommit(false);
            
            EmployeeInsertionExample.insertEmployeeData(con,1,"Deepak");
            
            EmployeeInsertionExample.insertEmployeeAddress(con,1,"1 Main Rd","Bang","India");
            
            //No commit the trasaction
            
            con.commit();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            try
            {
                con.rollback();
                System.out.println("JDBC Transaction rolled back successfully");
            }
            catch(SQLException e1)
            {
                System.out.println("SQL Exception in rollback" +e1.getMessage());
            }
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
