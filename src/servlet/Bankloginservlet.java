package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bankloginservlet
 */
@WebServlet("/Bankloginservlet")
public class Bankloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bankloginservlet() {
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
		
		String uname=request.getParameter("username");
		System.out.println("Username: "+uname);
		String pass=request.getParameter("password");
		System.out.println("password: "+pass);
		
			
		
		if(uname.equals("bank") && pass.equals("bank")) {
				
			response.sendRedirect("bankmainpage.jsp");
			
		}
					
	else{
		response.sendRedirect("error.jsp");
	}

		
		
	}

}
