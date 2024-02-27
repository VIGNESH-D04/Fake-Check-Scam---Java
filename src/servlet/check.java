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

import bean.charity;


import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

/**
 * Servlet implementation class check
 */
@WebServlet("/check")
public class check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public check() {
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
		

		charity b=new charity();
		
	 		 b.setCheckno((list.get(0).toString()));
		 	    System.out.println("Check Number :"+list.get(0).toString());
		 	    
		 	   b.setCheckword((list.get(1).toString()));
		 	    System.out.println("Amount in Word :"+list.get(1).toString());
		 	    
		 	   b.setDate((list.get(2).toString()));
		 	    System.out.println(" Date :"+list.get(2).toString());
		 	    
		 	   b.setCharityname((list.get(3).toString()));
		 	    System.out.println("Charity Name :"+list.get(3).toString());
		 	    
		 	   b.setDescription((list.get(4).toString()));
		 	    System.out.println("Description :"+list.get(4).toString());
		 	    
		 	   b.setAmount((list.get(5).toString()));
		 	    System.out.println("Amount :"+list.get(5).toString());
		 	    
		 	   b.setCemail((list.get(6).toString()));
		 	    System.out.println("Charity mail :"+list.get(6).toString());
		 	    
		 	   b.setPemail((list.get(7).toString()));
		 	    System.out.println("Public email :"+list.get(7).toString());
		 	    
			 	b.setStatus((list.get(8).toString()));
		 	    System.out.println("name:"+list.get(8).toString());
				
			    b.setCity((list.get(9).toString()));
		 	    System.out.println("State :"+list.get(9).toString());
		 	    
		 	  
		 	
		 	    
		 	   String encontent="";
				
				try {
					encontent = AES.encrypt99(list.get(0).toString());
					System.out.println("Encryption "+encontent);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				
			
				
		 	 b.setPic(filename);
		  
	    	b.setEncryptedchecno(encontent);
	    	
	
	 	
	 	
		
		inter in=new imple();
		int i=in.ches(b);
		if(i==1){
			response.sendRedirect("publicmainpage.jsp");
		}
		else{
			response.sendRedirect("error.jsp");
		} 

		
	}

	}

