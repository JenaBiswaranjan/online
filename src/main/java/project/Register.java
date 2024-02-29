package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response, Object dispatcher) throws ServletException, IOException {
		
		 
		 RequestDispatcher dispatcher1=null;
		try {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			String url="jdbc:mysql://localhost/details";
			Connection con=DriverManager.getConnection(url,"root","root");
			
			
			  dispatcher1 =request.getRequestDispatcher("Regitration.jsp");
			  String uname=request.getParameter("username");
				 String uemail=request.getParameter("email");
				 String uaddress=request.getParameter("address");
				 String upassword=request.getParameter("password");
			  PreparedStatement pst=con.prepareStatement("Insert Into user(uname,uemail,uaddress,upassword)values(?,?,?,?)");
				pst.setString(1, uname);
				pst.setString(2,uemail );
				pst.setString(3, uaddress);
				pst.setString(4, upassword);
				  int r=pst.executeUpdate();

			  if(r>0) {
				  request.setAttribute("status","success");
				  
				 	}
			  else {
				  request.setAttribute("status","failed");
			  }
			  
			  dispatcher1.forward(request, response);
			  con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
				
			}
			
	}

