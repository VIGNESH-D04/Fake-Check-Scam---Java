package servlet;

import imple.imple;
import inter.inter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.charityrequest;



/**
 * Servlet implementation class charityreq
 */
@WebServlet("/charityreq")
public class charityreq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public charityreq() {
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
		String name=request.getParameter("rname");
		String remail=request.getParameter("remail");
		String cemail=request.getParameter("cemail");
		String contact=request.getParameter("number");
		String message=request.getParameter("message");
		String cname=request.getParameter("cname");
		
		charityrequest b=new charityrequest();
		b.setRname(name);
		b.setRemail(remail);
		b.setCemail(cemail);
		b.setContact(contact);
		b.setPurpose(message);
		b.setCharityname(cname);
		
		inter n=new imple();
		int c=n.creq(b);
		if(c==1){
			response.sendRedirect("charitymainpage.jsp");
			
		}else{
			response.sendRedirect("error.jsp");
		}
	
	}

}
