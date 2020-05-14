package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class nameValidate
 */
@WebServlet("/nameValidate")
public class nameValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nameValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		if(name==null)
			response.sendRedirect("http://localhost:8080/appointment/");
		int n=name.length();
		if(n==0) {
			//response.getWriter().print("");
		}
		else {
			boolean flag=true;
			for(int i=0;i<n;i++) {
				char c=name.charAt(i);
				if((c>='A' && c<='Z') || (c>='a' && c<='z') || c==' ')
				{}
				else {
					flag=false;
					break;
				}
			}
			if(!flag)
				response.getWriter().print("Name must contain only alphabets");
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
