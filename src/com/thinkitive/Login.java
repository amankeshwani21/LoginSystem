package com.thinkitive;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 MyDatabaseOperations mb=new MyDatabaseOperations();	
		 boolean b;
		 
		 String name=request.getParameter("name");
		 String password=request.getParameter("pass");
		 
	
		b=mb.searchData(name,password);
		
		if(b){
			out.println("<h1>congrats..!! you sucessfully logedin into the system</h1>");
		}
		else{
			out.println("<h1>login failed</h1>");
		}
 
	}

}
