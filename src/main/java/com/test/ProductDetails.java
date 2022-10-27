package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connectivity.DBConnection;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//PrintWriter is used to get the response from the servlet and print the out put in the console/web
			PrintWriter out = response.getWriter();
			
			out.println("<html><body>");
			
			//Calling the property file values into our program, "./ is the basically denoting the file location
			
			InputStream in = getServletContext().getResourceAsStream("./config.properties");
			Properties props = new Properties();
			//To read the property file from location
			props.load(in);
			
			//Creating an object for DBconnection class
			DBConnection conn = new DBConnection(props.getProperty("url"),props.getProperty("userid"),props.getProperty("password"));
			
			String query1 ="select * from mobile_products";
		
			Statement smt = conn.getConnection().createStatement();	
			
			ResultSet rs = smt.executeQuery(query1);
			
			out.println("<table>");
			
			while(rs.next()) {
				
			out.println("<tr><td>"+rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3)+"</td></tr>");
			out.println("<table>");
			}
			//To display the output as HTML Page
			out.println("</body></html>");
			
			//smt.close();
			//To close the connection 
			conn.closeConnection();
			
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
