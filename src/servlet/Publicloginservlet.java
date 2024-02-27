package servlet;


import imple.imple;
import inter.inter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.publicreg;




/**
 * Servlet implementation class Publicloginservlet
 */
@WebServlet("/Publicloginservlet")
public class Publicloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Publicloginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name=request.getParameter("username");
		System.out.println("username:"+name);
		
		String pass=request.getParameter("password");
		System.out.println("password:"+pass);
		
		HttpSession sess=request.getSession();
		sess.setAttribute( "pemail",name);
		System.out.println("email: "+name);
		
		publicreg ur=new publicreg();
		ur.setPemail(name);
		ur.setPassword(pass);
		
		inter in=new imple();
		boolean log=in.plog(ur);
		
		if(log==true){
			response.sendRedirect("publicmainpage.jsp");
		}
		else{
			response.sendRedirect("error.jsp");
		}

		
		
	}

}
