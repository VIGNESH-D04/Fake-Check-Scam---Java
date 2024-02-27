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

import bean.Charitybean;

/**
 * Servlet implementation class Fakecharservlet
 */
@WebServlet("/Fakecharservlet")
public class Fakecharservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fakecharservlet() {
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
		
		String cemail=request.getParameter("username");
		System.out.println("Username :"+cemail);
		
		HttpSession sess=request.getSession();
		sess.setAttribute( "cemail",cemail);
		System.out.println("email: "+cemail);
		
		String pass=request.getParameter("password");
		System.out.println("Password :"+pass);
		
		Charitybean cb=new Charitybean();
		cb.setCemail(cemail);
		cb.setPassword(pass);
		
		inter in=new imple();
		boolean log=in.clog(cb);
		
		if(log==true)
		{
			response.sendRedirect("Fakecharmain.jsp");
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
		
	}
	

}
