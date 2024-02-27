package servlet;




import imple.imple;
import inter.inter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Charitybean;
import bean.publicreg;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;




/**
 * Servlet implementation class Publicregservlet
 */
@WebServlet("/Publicregservlet")
public class Publicregservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Publicregservlet() {
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
		
		
		String filetype=null;
		Part part;
		FilePart filepart;
		long size=0;
		String filename=null;
		
		filename=request.getParameter("filename");
		System.out.println("filename:"+filename);
 
		MultipartParser mp = new MultipartParser(request, 999999999);
		 
		
		PrintWriter out=response.getWriter();
		
		ArrayList list=new ArrayList<>();
		
		 
		
		String path = getServletContext().getRealPath(" ");
		System.out.println(path);
		

		String editPath = path.substring(0, path.indexOf("."));
		System.out.println(editPath);
		
		String fullpath = editPath + "check\\WebContent\\Local1\\";
		System.out.println(fullpath);
		
		while ((part = mp.readNextPart()) != null)
		{
			if (part.isFile()) {
				filepart = (FilePart) part;
				
				filetype = filepart.getContentType();

				 filename = filepart.getFileName();
				System.out.println(filename);

				fullpath = fullpath + filename;
				System.out.println(fullpath);
				
				File file = new File(fullpath);
				size = filepart.writeTo(file);
				
				BufferedReader br = new BufferedReader(new FileReader(file));
		
				
			}
			else if(part.isParam())
			{
				ParamPart param = (ParamPart) part;
				String name = param.getName();
				
				String value = param.getStringValue();

				System.out.println("Loadinggg...... " + value);
				list.add(value);					
			}				
		}
		publicreg b=new publicreg();
		
	 		 b.setPname((list.get(0).toString()));
		 	    System.out.println("name:"+list.get(0).toString());
		 	    
		 	   b.setPemail((list.get(1).toString()));
		 	    System.out.println("name:"+list.get(1).toString());
		 	    
		 	   b.setMobilenumber((list.get(2).toString()));
		 	    System.out.println("name:"+list.get(2).toString());
		 	    
		 	   b.setPassword((list.get(3).toString()));
		 	    System.out.println("name:"+list.get(3).toString());
		 	    
		 	   b.setConpass((list.get(4).toString()));
		 	    System.out.println("name:"+list.get(4).toString());
		 	    
		 	   b.setGender((list.get(5).toString()));
		 	    System.out.println("name:"+list.get(5).toString());
		 	    
		 	  
		 	    
		 	  
		 	    
		 	  
	 	    
	 	   b.setPic(filename);
		  
	 
	  
	 	   inter pdtt=new imple();
		     int pt=pdtt.preg(b);
		     if(pt==1){
						response.sendRedirect("publiclogin.jsp");
					}
					else
					{
						response.sendRedirect("Error");
					}
	}
}
